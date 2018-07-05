package com.example.administrator.myspinner_for_sandboxtest;

public class mybasecolor {
    private String mycolor;
    private String myname;
    mybasecolor(){

    }
    mybasecolor(String temp_color,String temp_name){
        this.mycolor = temp_color;
        this.myname = temp_name;
    }

    public String getColor() {
        return mycolor;
    }

    public void setColor(String color) {
        this.mycolor = color;
    }

    public String getName() {
        return myname;
    }

    public void setName(String name) {
        this.myname = name;
    }
}
