package com.example.securechatapp;

public class Test_data {
    private String Names;
    private String unames;
    private String gender;

    public Test_data(String name, String uname, String gender) {
        this.Names = name;
        this.unames = uname;
        this.gender = gender;
    }

    public String getNames() {
        return Names;
    }

    public String getUnames() {
        return unames;
    }

    public String getGender(){ return gender; }

}

