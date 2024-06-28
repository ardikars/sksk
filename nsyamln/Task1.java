package org.example;
//SKSK Batch 23 (BE Course)

//Maulina Inas Nasya

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama siswa: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan jumlah mata pelajaran : ");
        int jumlahMataPelajaran = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        double totalNilai = 0;
        for (int j = 0; j < jumlahMataPelajaran; j++) {
            System.out.print("Masukkan nilai mata pelajaran ke-" + (j + 1) + ": ");
            double nilai = scanner.nextDouble();
            totalNilai += nilai;
        }

        double rataRata = totalNilai / jumlahMataPelajaran;

        // Output rincian nilai siswa
        System.out.println("\n--- Rincian Nilai Siswa ---");
        System.out.println("Nama Siswa: " + nama);
        System.out.println("Rata-rata Nilai: " + rataRata);

        // Menambahkan keterangan berdasarkan rata-rata nilai
        String keterangan;
        if (rataRata >= 85) {
            keterangan = "Baik";
        } else if (rataRata >= 70) {
            keterangan = "Cukup";
        } else {
            keterangan = "Kurang";
        }
        System.out.println("Keterangan: " + keterangan);
    }
}
