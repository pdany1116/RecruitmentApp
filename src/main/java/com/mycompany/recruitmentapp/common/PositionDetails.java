package com.mycompany.recruitmentapp.common;

import com.mycompany.recruitmentapp.entity.Candidate;
import com.mycompany.recruitmentapp.entity.User;
import java.util.Collection;

/**
 *
 * @author Dani
 */
public class PositionDetails implements java.io.Serializable {
    private Integer id;
    private String name;
    private String department;
    private String project;
    private String requirements;
    private String responsibilities;
    private String state;
    private Integer maxCandidates;   
    private User user;
    private Collection<Candidate> candidates;

    public PositionDetails(Integer id, String name, String department, String project, String requirements, String responsibilities, String state, Integer maxCandidates, User user, Collection<Candidate> candidates) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.project = project;
        this.requirements = requirements;
        this.responsibilities = responsibilities;
        this.state = state;
        this.maxCandidates = maxCandidates;
        this.user = user;
        this.candidates = candidates;
    }


    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getMaxCandidates() {
        return maxCandidates;
    }

    public void setMaxCandidates(Integer maxCandidates) {
        this.maxCandidates = maxCandidates;
    } 
    
        public Collection<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Collection<Candidate> candidates) {
        this.candidates = candidates;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
