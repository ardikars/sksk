package com.example;

public class Siswa {
    private String nama;
    private int bhsIndo;
    private int mtk;
    private int inggris;
    private int pkn;
    private int ipa;

    public Siswa(String nama, int bhsIndo, int mtk, int inggris, int pkn,int ipa ){
        this.nama=nama;
        this.bhsIndo=bhsIndo;
        this.mtk=mtk;
        this.inggris=inggris;
        this.pkn=pkn;
        this.ipa=ipa;
    }

    public String getName(){
        return nama;
    }

    public int getBhsIndo(){
        return bhsIndo;
    }

    public int getMtk(){
        return mtk;
    }

    public int getInggris(){
        return inggris;
    }

    public int getPkn(){
        return pkn;
    }

    public int getIpa(){
        return ipa;
    }

}
