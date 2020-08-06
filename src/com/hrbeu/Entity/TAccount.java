package com.hrbeu.Entity;

public class TAccount {
    private String Account_ID;
    private String Concat_Person;
    private String Concat_Address;
    private double Account_Balance;
    private String password;
    public TAccount(){}

    public String getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(String account_ID) {
        Account_ID = account_ID;
    }

    public String getConcat_Person() {
        return Concat_Person;
    }

    public void setConcat_Person(String concat_Person) {
        Concat_Person = concat_Person;
    }

    public String getConcat_Address() {
        return Concat_Address;
    }

    public void setConcat_Address(String concat_Address) {
        Concat_Address = concat_Address;
    }

    public double getAccount_Balance() {
        return Account_Balance;
    }

    public void setAccount_Balance(double account_Balance) {
        Account_Balance = account_Balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TAccount(String account_ID, String concat_Person, String concat_Address, double account_Balance, String password) {
        Account_ID = account_ID;
        Concat_Person = concat_Person;
        Concat_Address = concat_Address;
        Account_Balance = account_Balance;
        this.password = password;
    }

    public TAccount(String account_ID, String password) {
        Account_ID = account_ID;
        this.password = password;
    }
}

