package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Program Perhitungan Nilai Rata-Rata SD==== ");
        System.out.println("Jika Nilai Rata-Rata Mahasiswa di bawah 50 = D, 51-69 = C, 70-79 = B, 80-100= A");

        InputHandler inputHandler = new InputHandler();
        Siswa siswa = inputHandler.getSiswaInfo();

        Calkulator calkulator = new Calkulator();
        double average = calkulator.calculator(siswa);

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printResult(siswa.getName(), average);
    }
}
