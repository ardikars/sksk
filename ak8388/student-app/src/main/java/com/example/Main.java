package com.example;

import java.util.*;
import com.google.gson.Gson;

// Annur Akbar Bahagia
// BE(Java) SKSK Batch 23

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========>Mini Program<=========");
        System.out.println("1. Mini Kalkulator");
        System.out.println("2. Estimasi Waktu Perjalanan");
        System.out.println("3. Perhitungan IP");
        System.out.print("Pilih Program :");
        String plih = scanner.next();

        switch (plih) {
            case "1": {
                kalkulator calc = new kalkulator();
                System.out.println("=========>Pilih Oprasi<=========");
                System.out.println("+");
                System.out.println("-");
                System.out.println("/");
                System.out.println("x");
                System.out.println("%");

                System.out.print("Oprasi :");
                String oprasi = scanner.next();

                System.out.print("Nilai1 :");
                int nilai = scanner.nextInt();

                System.out.print("Nilai1 :");
                int nilai2 = scanner.nextInt();
                System.out.println("Hasil = " + calc.calc(oprasi, nilai, nilai2));
                break;
            }
            case "2": {
                estimasiWaktu estimateTime = new estimasiWaktu();
                System.out.print("Jarak tempuh :");
                int jarak = scanner.nextInt();

                System.out.print("Kecepatan :");
                int kecepatan = scanner.nextInt();

                System.out.println("Estimasi Waktu tempuh = " + estimateTime.estimateTime(jarak, kecepatan) + " Jam");
                break;
            }
            case "3": {
                Scanner scan = new Scanner(System.in);
                Gson gson = new Gson();

                String Nim;
                String Name;
                String Address;
                String Major;
                int Age;
                int nmbr;

                System.out.print("Nim :");
                Nim = scan.nextLine();

                System.out.print("Name :");
                Name = scan.nextLine();

                System.out.print("Address :");
                Address = scan.nextLine();

                System.out.print("Major :");
                Major = scan.nextLine();

                System.out.print("Age :");
                Age = scan.nextInt();

                Student student = new Student(Nim, Name, Address, Major, Age);
                System.out.println("");
                System.out.println("====> IP Calculation <====");

                System.out.print("Number of courses :");
                nmbr = scan.nextInt();

                IPCalculation ipCalc2 = new IPCalculation();
                for (int a = 1; a <= nmbr; a++) {

                    System.out.print("Course Name :");
                    String course = scan.next();
                    ipCalc2.setCourseName(course);

                    System.out.print("SKS :");
                    int sks = scan.nextInt();
                    ipCalc2.setSks(sks);

                    System.out.print("Grade :");
                    String grade = scan.next();
                    ipCalc2.setGrade(grade);
                    System.out.println("");
                }

                String strJSon = gson.toJson(student);

                System.out.println("Data Student :" + strJSon);
                System.out.printf("IP :%.2f", ipCalc2.getclacIP());
                System.out.println();

                scan.close();
                break;
            }
            default:{
                System.out.println("Your Chose Not Valid");
            }
        }

        scanner.close();
    }
}

class kalkulator {
    private int result;

    // Calculator Function
    public int calc(String opration, int nilai, int nilai2) {

        switch (opration) {
            case "+": {
                result = nilai + nilai2;
                break;
            }
            case "-": {
                result = nilai - nilai2;
                break;
            }
            case "/": {
                result = nilai2 == 0 ? 0 : nilai + nilai2;
                break;
            }
            case "x": {
                result = nilai * nilai2;
                break;
            }
            case "%": {
                result = nilai % nilai2;
                break;
            }
            default: {
                System.out.println("Oprasi Tidak Valid");
            }
        }
        return result;
    }
}

class estimasiWaktu {

    private float result = 0;

    public float estimateTime(int jarak, int kecepatan) {
        if (jarak == 0 || kecepatan == 0) {
            System.out.println("input kecepatan dan jarak dengan benar");
        } else {
            result = jarak / kecepatan;
        }

        return result;
    }
}
