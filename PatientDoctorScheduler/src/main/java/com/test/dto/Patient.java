package com.test.dto;

import javax.persistence.*;
@Entity
@Table(name = "patientRepository")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int age;
    private String phoneNumber;
    private String emailId;
    
    public Patient() {
    }
    public Patient(String name, int age, String phoneNumber, String emailId) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    @Override
    public String toString() {
        return "Patient{" +
                ", name='" + name + '\'' +
                ", Age=" + age + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailId=" + emailId +
                '}';
    }
}