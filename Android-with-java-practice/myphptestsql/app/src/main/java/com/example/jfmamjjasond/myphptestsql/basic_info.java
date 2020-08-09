package com.example.jfmamjjasond.myphptestsql;

public class basic_info {

    private String basic_name;
    private String basic_tel;
    private String basic_mail;

    public basic_info() {
    }
    public basic_info(String name,String tel,String mail) {
        basic_name = name;
        basic_tel = tel;
        basic_mail = mail;
    }

    public String getBasic_name() {
        return basic_name;
    }

    public void setBasic_name(String basic_name) {
        this.basic_name = basic_name;
    }

    public String getBasic_tel() {
        return basic_tel;
    }

    public void setBasic_tel(String basic_tel) {
        this.basic_tel = basic_tel;
    }

    public String getBasic_mail() {
        return basic_mail;
    }

    public void setBasic_mail(String basic_mail) {
        this.basic_mail = basic_mail;
    }
}
