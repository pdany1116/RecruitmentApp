package com.mycompany.recruitmentapp.common;

/**
 *
 * @author Dani
 */
public class UserDetails implements java.io.Serializable {
    private Integer id;
    private String description;
    private String firstName;
    private String lastName;
    private String internalFunction;
    private String phone;
    private String email;
    private String position;
    private String username;

    public UserDetails(Integer id, String description, String firstName, String lastName, String internalFunction, String phone, String email, String position, String username) {
        this.id = id;
        this.description = description;
        this.firstName = firstName;
        this.lastName = lastName;
        this.internalFunction = internalFunction;
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

    public String getInternalFunction() {
        return internalFunction;
    }

    public void setInternalFunction(String internalFunction) {
        this.internalFunction = internalFunction;
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
