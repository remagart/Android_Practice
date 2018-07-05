package com.example.administrator.myspinner_for_sandboxtest;

public class mybasecolor {
    private String color;
    private String name;
    mybasecolor(){

    }
    mybasecolor(String temp_color,String temp_name){
        this.color = temp_color;
        this.name = temp_name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
