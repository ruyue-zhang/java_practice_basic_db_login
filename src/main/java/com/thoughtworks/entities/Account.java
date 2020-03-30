package com.thoughtworks.entities;

public class Account extends User{
    private int errorNo;
    private String status;

    public Account() {
    }

    public Account(String name, String phoneNumber, String email, String password, int errorNo, String status) {
        super(name, phoneNumber, email, password);
        this.errorNo = errorNo;
        this.status = status;
    }

    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
