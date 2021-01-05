/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.recruitmentapp.common;

/**
 *
 * @author Dani
 */
public class UserDetails implements java.io.Serializable {
    private Integer id;
    private String description;
    private String firstname;
    private String lastname;
    private String internalfunction;
    private String phone;
    private String email;
    private String position;
    private String username;

    public UserDetails(Integer id, String description, String firstname, String lastname, String internalfunction, String phone, String email, String position, String username) {
        this.id = id;
        this.description = description;
        this.firstname = firstname;
        this.lastname = lastname;
        this.internalfunction = internalfunction;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getInternalfunction() {
        return internalfunction;
    }

    public void setInternalfunction(String internalfunction) {
        this.internalfunction = internalfunction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   
    
    
    
}
