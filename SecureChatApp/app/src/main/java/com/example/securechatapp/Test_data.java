package com.example.securechatapp;

import java.util.ArrayList;

public class Test_data {
    public String Names;
    public String unames;

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public String getUnames() {
        return unames;
    }

    public void setUnames(String unames) {
        this.unames = unames;
    }

    public Test_data(String names, String unames) {
        Names = names;
        this.unames = unames;
    }
}