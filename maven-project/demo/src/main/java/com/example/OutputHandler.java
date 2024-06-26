package com.example;

public class OutputHandler {
    public void printResult(String name, double average){
        System.out.println("Nama "+ name);
        if(average>1 && average < 50){
            System.out.println("Nalai Anda " + average +" D");
         }else if(average>=50 && average<70){
            System.out.println("Nalai Anda " + average +" C");
         }else if(average>=70 && average<80){
             System.out.println("Nalai Anda " + average +" B");
         }else if(average >=80 && average<=100){
            System.out.println("Nalai Anda " + average +" A");
         }else{
            System.out.println("Nilai Tidak Sesuai Kriteria");
         } 


    }
}
