package com.example.adminsidedealsonwheels.ui.CustomerService;

public class CustomerServicePOJO
{
    String id, phoneNumber, problem, status, personId;

    public CustomerServicePOJO()
    {}

    public CustomerServicePOJO(String id, String phoneNumber, String problem, String status, String personId) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.problem = problem;
        this.status = status;
        this.personId = personId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
