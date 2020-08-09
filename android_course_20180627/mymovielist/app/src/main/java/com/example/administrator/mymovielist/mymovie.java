package com.example.administrator.mymovielist;

public class mymovie {
    private int imgg;
    private String myname;
    private String mydate;
    private String myintro;
    public mymovie() {

    }

    public String getMyname() {
        return myname;
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public String getMydate() {
        return mydate;
    }

    public void setMydate(String mydate) {
        this.mydate = mydate;
    }

    public String getMyintro() {
        return myintro;
    }

    public void setMyintro(String myintro) {
        this.myintro = myintro;
    }

    public int getImgg() {
        return imgg;
    }

    public void setImgg(int imgg) {
        this.imgg = imgg;
    }

    public mymovie(int imgg, String my_n, String my_d, String my_i ){
        this.imgg = imgg;
        this.myname = my_n;
        this.mydate = my_d;
        this.myintro = my_i;
    }
}
