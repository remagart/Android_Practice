package com.example.administrator.mymovielist;

public class mymovie {
    private int imgg;
    private String myname;
    private String mydate;
    private String myintro;
    public mymovie() {

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
