package com.mycompany.recruitmentapp.common;

import com.mycompany.recruitmentapp.entity.Position;
import com.mycompany.recruitmentapp.entity.CV;
import java.sql.Date;

/**
 *
 * @author lucis
 */
public class CandidateDetails {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String mail;
    private String address;
    private String comment;
    private Date interviewDate;
    private Position position;
    private CV cv;

    public CandidateDetails(Integer id, String firstName, String lastName, String phone, String mail, String address, String comment, Date interviewDate, Position position, CV cv) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.comment = comment;
        this.interviewDate = interviewDate;
        this.position = position;
        this.cv = cv;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }
}
