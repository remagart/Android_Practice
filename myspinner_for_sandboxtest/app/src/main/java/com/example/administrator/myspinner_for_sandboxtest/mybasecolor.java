package com.example.administrator.myspinner_for_sandboxtest;

public class mybasecolor {
    private int color;
    private String name;
    mybasecolor(){

    }
    mybasecolor(int temp_color,String temp_name){
        this.color = temp_color;
        this.name = temp_name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
