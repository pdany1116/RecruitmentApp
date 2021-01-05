package com.mycompany.recruitmentapp.common;
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

    public PositionDetails(Integer id, String name, String department, String project, String requirements, String responsibilities, String state, Integer maxCandidates) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.project = project;
        this.requirements = requirements;
        this.responsibilities = responsibilities;
        this.state = state;
        this.maxCandidates = maxCandidates;
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
}
