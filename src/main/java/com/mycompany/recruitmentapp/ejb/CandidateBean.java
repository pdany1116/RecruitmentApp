/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.ejb;

import com.mycompany.recruitmentapp.entity.CV;
import com.mycompany.recruitmentapp.common.CandidateDetails;
import com.mycompany.recruitmentapp.entity.Candidate;
import com.mycompany.recruitmentapp.entity.Position;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lucis
 */
@Stateless
public class CandidateBean {

    @PersistenceContext
    private EntityManager entityManager;
    
    public void updateComment (Integer candidateId, String comment ){
        
        Candidate candidate = entityManager.find(Candidate.class, candidateId);
        candidate.setComment(comment);
        
        
    }
    public void updatePositionState(Integer positionId, String state){
            
            Position position = entityManager.find(Position.class, positionId);
            position.setState(state);
            
        }
    
     public CandidateDetails findById (Integer candidateId) {
        Candidate candidate = entityManager.find(Candidate.class, candidateId);
        return new CandidateDetails (candidate.getId(), 
                                candidate.getFirstName(),
                                candidate.getLastName(),
                                candidate.getPhone(),
                                candidate.getMail(),
                                candidate.getAddress(),
                                candidate.getComment(),
                                candidate.getInterviewDate(),
                                candidate.getPosition(),
                                candidate.getCv()
        );
    }
    
    public void createCandidate(String firstName, String lastName, String phone, String mail, String address, String comment, Date interviewDate, Integer positionId, String fileName, String fileType, byte[] fileContent){
        Candidate candidate = new Candidate();
        candidate.setFirstName(firstName);
        candidate.setLastName(lastName);
        candidate.setPhone(phone);
        candidate.setMail(mail);
        candidate.setAddress(address);
        candidate.setComment(comment);
        candidate.setInterviewDate(interviewDate);
        
        CV newCv = new CV();
        newCv.setFileName(fileName);
        newCv.setFileType(fileType);
        newCv.setFileContent(fileContent);
        newCv.setCandidate(candidate);
        
        candidate.setCv(newCv);
        
        Position position = entityManager.find(Position.class, positionId);
        candidate.setPosition(position);
        position.getCandidates().add(candidate);
        entityManager.persist(candidate);
        entityManager.persist(newCv);
    }
        
    public List<CandidateDetails> getAllCandidates() {
        try {
            List<Candidate> candidates = (List<Candidate>) entityManager.createQuery("SELECT c FROM Candidate c").getResultList();
            return copyCandidatesToDetails(candidates);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    public List<CandidateDetails> copyCandidatesToDetails(List<Candidate> candidates) {
        List <CandidateDetails> detailsList = new ArrayList<>();
        for (Candidate candidate : candidates) {
            CandidateDetails candidateDetails = new CandidateDetails( candidate.getId(),
                        candidate.getFirstName(),
                        candidate.getLastName(),
                        candidate.getPhone(),
                        candidate.getMail(),
                        candidate.getAddress(),
                        candidate.getComment(),
                        candidate.getInterviewDate(),
                        candidate.getPosition(),
                        candidate.getCv()
            );
            detailsList.add(candidateDetails);
        }
        return detailsList;
    }
    
}
