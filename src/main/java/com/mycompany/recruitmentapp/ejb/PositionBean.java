/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.ejb;

import com.mycompany.recruitmentapp.common.PositionDetails;
import com.mycompany.recruitmentapp.entity.Position;
import com.mycompany.recruitmentapp.entity.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dani
 */
@Stateless
public class PositionBean {

    @PersistenceContext
    private EntityManager entityManager;

    public void createPosition(String name, String department, String project, String requirements, String responsibilities, Integer maxCandidates, Integer userId) {
        Position position = new Position();
        position.setState("Inactive");
        position.setDepartment(department);
        position.setMaxCandidates(maxCandidates);
        position.setName(name);
        position.setProject(project);
        position.setRequirements(requirements);
        position.setResponsibilities(responsibilities);
        
        User user = entityManager.find(User.class, userId);
        position.setUser(user);
        
        entityManager.persist(position);
    }
    public List<PositionDetails> getAllPositions() {
        try {
            List<Position> positions = (List<Position>) entityManager.createQuery("SELECT u FROM Position u").getResultList();
            /* Order the list by state */
            Collections.sort(positions, new Comparator<Position>() {
                @Override
                public int compare(final Position position1, final Position position2) {
                    return position1.getState().compareTo(position2.getState());
                }
            });
            return copyPositionsToDetails(positions);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<PositionDetails> copyPositionsToDetails(List<Position> positions) {
        List <PositionDetails> detailsList = new ArrayList<>();
        for (Position position : positions) {
            PositionDetails positionDetails = new PositionDetails(position.getId(),                
                    position.getName(),
                    position.getDepartment(),
                    position.getProject(),
                    position.getRequirements(),
                    position.getResponsibilities(),
                    position.getState(),
                    position.getMaxCandidates(),
                    position.getUser(),
                    position.getCandidates()
            );
            detailsList.add(positionDetails);
        }
        return detailsList;
    }
    
        public void updatePosition(Integer positionId,String name, String department, String project, String requirements, String responsibilities, Integer maxCandidates, String state, Integer userId) {
        Position position = entityManager.find(Position.class, positionId);
       //position.setState("Inactive");
        position.setDepartment(department);
        position.setMaxCandidates(maxCandidates);
        position.setName(name);
        position.setProject(project);
        position.setRequirements(requirements);
        position.setResponsibilities(responsibilities);
        
        
      
    }
        public void updatePositionState(Integer positionId, String state){
            
            Position position = entityManager.find(Position.class, positionId);
            position.setState(state);
            
        }
        
        public void reactivatePosition(Integer positionId){
            
            Position position = entityManager.find(Position.class, positionId);
                                
            Position newPosition = new Position();
            newPosition.setState("Active");
            newPosition.setDepartment(position.getDepartment());
            newPosition.setMaxCandidates(position.getMaxCandidates());
            newPosition.setName(position.getName());
            newPosition.setProject(position.getProject());
            newPosition.setRequirements(position.getRequirements());
            newPosition.setResponsibilities(position.getResponsibilities());

            User user = entityManager.find(User.class, position.getUser().getId());
            newPosition.setUser(user);

            entityManager.persist(newPosition);
        }
        
        public PositionDetails findById (Integer positionId) {
        Position position = entityManager.find(Position.class, positionId);
        return new PositionDetails (position.getId(), 
                                position.getName(), 
                                position.getDepartment(), 
                                position.getProject(), 
                                position.getRequirements(), 
                                position.getResponsibilities(), 
                                position.getState(), 
                                position.getMaxCandidates(),
                                position.getUser(),
                                position.getCandidates()
                                        );


    }
}
