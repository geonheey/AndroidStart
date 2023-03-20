package com.example.urssuproject;

public class Information {
    private String name;
    private String num;

    public Information(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Information(String name, String num){
        this.name = name;
        this.num = num;
    }
}
