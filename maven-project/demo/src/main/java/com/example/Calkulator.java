package com.example;

public class Calkulator {
public double calculator(Siswa siswa){
    int sum= siswa.getBhsIndo()+siswa.getInggris()+siswa.getMtk()+siswa.getPkn()+siswa.getIpa();

    return (double) sum/5;
}

}
