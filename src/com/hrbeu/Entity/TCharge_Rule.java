package com.hrbeu.Entity;

public class TCharge_Rule {
    private String Rule_ID;
    private String Func_Name;
    private TCharge tCharge;

    public TCharge_Rule(String rule_ID, String func_Name, TCharge tCharge) {
        Rule_ID = rule_ID;
        Func_Name = func_Name;
        this.tCharge = tCharge;
    }

    public String getRule_ID() {
        return Rule_ID;
    }

    public void setRule_ID(String rule_ID) {
        Rule_ID = rule_ID;
    }

    public String getFunc_Name() {
        return Func_Name;
    }

    public void setFunc_Name(String func_Name) {
        Func_Name = func_Name;
    }

    public TCharge gettCharge() {
        return tCharge;
    }

    public void settCharge(TCharge tCharge) {
        this.tCharge = tCharge;
    }
}
