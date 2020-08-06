package com.hrbeu.Entity;

public class TCharge {
    private String Charge_Code;
    private String Charge_Name;
    private int Charge;

    public TCharge(String charge_Code, String charge_Name, int charge) {
        Charge_Code = charge_Code;
        Charge_Name = charge_Name;
        Charge = charge;
    }

    public String getCharge_Code() {
        return Charge_Code;
    }

    public void setCharge_Code(String charge_Code) {
        Charge_Code = charge_Code;
    }

    public String getCharge_Name() {
        return Charge_Name;
    }

    public void setCharge_Name(String charge_Name) {
        Charge_Name = charge_Name;
    }

    public int getCharge() {
        return Charge;
    }

    public void setCharge(int charge) {
        Charge = charge;
    }
}
