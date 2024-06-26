package com.example;

import java.util.Scanner;

public class InputHandler {
    public Siswa getSiswaInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Siswa: ");
        String name = scanner.nextLine();
        System.out.print("Nilai Bhs. Indonesia: ");
        int a = scanner.nextInt();
        System.out.print("Nilai MTK: ");
        int b = scanner.nextInt();
        System.out.print("Nilai Bhs. Inggris: ");
        int c = scanner.nextInt();
        System.out.print("Nilai PKN: ");
        int d = scanner.nextInt();
        System.out.print("Nilai IPA: ");
        int e = scanner.nextInt();

        return new Siswa(name, a, b, c, d, e);
    }
}
