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

    public static final Logger LOG = Logger.getLogger(PositionBean.class.getName());
    
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
        //user.getOpenPositions().add(position);
        position.setUser(user);
        
        entityManager.persist(position);
    }
    public List<PositionDetails> getAllPositions() {
        try {
            List<Position> positions = (List<Position>) entityManager.createQuery("SELECT u FROM Position u").getResultList();
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
                    position.getMaxCandidates()
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
        
        public PositionDetails findById (Integer positionId) {
        Position position = entityManager.find(Position.class, positionId);
        return new PositionDetails (position.getId(), 
                                position.getName(), 
                                position.getDepartment(), 
                                position.getProject(), 
                                position.getRequirements(), 
                                position.getResponsibilities(), 
                                position.getState(), 
                                position.getMaxCandidates());


    }
}
