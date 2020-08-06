package com.hrbeu.Entity;

public class  TUser {
    private int User_ID;
    private TMobiles tMobiles;
    private String Roaming_Status;
    private String Com_Level;
    private TCustomer tCustomer;
    private TAccount tAccount;

    public TUser(int user_ID, TMobiles tMobiles, String roaming_Status, String com_Level, TCustomer tCustomer, TAccount tAccount) {
        User_ID = user_ID;
        this.tMobiles = tMobiles;
        Roaming_Status = roaming_Status;
        Com_Level = com_Level;
        this.tCustomer = tCustomer;
        this.tAccount = tAccount;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public TMobiles gettMobiles() {
        return tMobiles;
    }

    public void settMobiles(TMobiles tMobiles) {
        this.tMobiles = tMobiles;
    }

    public String getRoaming_Status() {
        return Roaming_Status;
    }

    public void setRoaming_Status(String roaming_Status) {
        Roaming_Status = roaming_Status;
    }

    public String getCom_Level() {
        return Com_Level;
    }

    public void setCom_Level(String com_Level) {
        Com_Level = com_Level;
    }

    public TCustomer gettCustomer() {
        return tCustomer;
    }

    public void settCustomer(TCustomer tCustomer) {
        this.tCustomer = tCustomer;
    }

    public TAccount gettAccount() {
        return tAccount;
    }

    public void settAccount(TAccount tAccount) {
        this.tAccount = tAccount;
    }
}
