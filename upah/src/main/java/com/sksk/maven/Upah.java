package com.sksk.maven;

import java.util.Scanner;

public class Upah {

    public Upah (){

        Scanner scanner = new Scanner(System.in);

        double upahPerBuah = 450;
        double bonus = 0 ;

        System.out.print("Nama Pekerja : ");
        String nama = scanner.nextLine();

        System.out.print("Jumlah barang selesai : ");
        int jumlah = scanner.nextInt();

        System.out.print("Apakah Lembur (true / false) ? ");
        boolean lembur = scanner.nextBoolean();

        double totalUpah = hitungUpah(upahPerBuah, jumlah, lembur, bonus);

        System.out.print("\nNama : " + nama);
        System.out.print("\nTotal Upah : " + totalUpah);

        scanner.close();
    }

    private static double hitungUpah(double upahPerBuah, int jumlah, boolean lembur, double bonus) {
        if (jumlah >= 100) {
            bonus = (upahPerBuah / 4) * jumlah;
        }
        double tarifAkhir = lembur ? upahPerBuah * 2 : upahPerBuah;

        return (jumlah * tarifAkhir + bonus);
    }
}
