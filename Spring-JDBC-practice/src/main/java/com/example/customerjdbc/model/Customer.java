package com.example.customerjdbc.model;

public class Customer {

    private int id;
    private String fullName;
    private String email;
    private String socialSecurityNumber;

    public Customer() {
    }

    public Customer(int id, String fullName, String email, String socialSecurityNumber) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // toString
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", ssn='" + socialSecurityNumber + '\'' +
                '}';
    }
}
