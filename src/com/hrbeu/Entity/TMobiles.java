package com.hrbeu.Entity;

public class TMobiles {
    private String Mobile_Number;
    private String Mobile_Type;
    private String Is_Avaiable;
    public TMobiles(String Mobile_Number){
        this.Mobile_Number = Mobile_Number;
    }
    public String getMobile_Number() {
        return Mobile_Number;
    }

    public void setMobile_Number(String mobile_Number) {
        Mobile_Number = mobile_Number;
    }

    public String getMobile_Type() {
        return Mobile_Type;
    }

    public void setMobile_Type(String mobile_Type) {
        Mobile_Type = mobile_Type;
    }

    public String getIs_Avaiable() {
        return Is_Avaiable;
    }

    public void setIs_Avaiable(String is_Avaiable) {
        Is_Avaiable = is_Avaiable;
    }
    public TMobiles(){}

    public TMobiles(String mobile_Number, String mobile_Type,String is_Avaiable) {
        Mobile_Number = mobile_Number;
        Mobile_Type = mobile_Type;
        Is_Avaiable = is_Avaiable;
    }
}
