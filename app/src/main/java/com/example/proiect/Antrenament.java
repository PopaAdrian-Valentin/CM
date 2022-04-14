package com.example.proiect;

import java.io.Serializable;

public class Antrenament implements Serializable {

    private int id;
    private String nume;
    private int exid1;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    private int exid2;
    private int exid3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExid1() {
        return exid1;
    }

    public void setExid1(int exid1) {
        this.exid1 = exid1;
    }

    public int getExid2() {
        return exid2;
    }

    public void setExid2(int exid2) {
        this.exid2 = exid2;
    }

    public int getExid3() {
        return exid3;
    }

    public void setExid3(int exid3) {
        this.exid3 = exid3;
    }
}
