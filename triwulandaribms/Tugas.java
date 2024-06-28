// NAMA : TRI WULANDARI
// TUGAS 1 BE 
import java.util.Scanner;

public class Tugas{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int pilih;
        double sisi, luasPersegi;
        double panjang, lebar, luasPersegiPanjang;
        double alas, tinggi, luasSegitiga;
        double alasJang, tinggiJang, luasJajargenjang;
        double jari, luasLingkaran;
        float phi = 3.14f;

        System.out.println("\nPROGRAM HITUNG LUAS BANGUN DATAR");
        System.out.println("\nPilih bangun datar:");
        System.out.println("1. Persegi");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Segitiga");
        System.out.println("4. Jajar Genjang");
        System.out.println("5. Lingkaran");

        System.out.print("Masukkan pilihan: ");
        pilih = scanner.nextInt();

        if (pilih == 1) {
            System.out.print("Masukkan sisi: ");
            sisi = scanner.nextDouble();
            luasPersegi = hitungLuasPersegi(sisi);
            System.out.println("Luas persegi: " + luasPersegi);
        } else if (pilih == 2) {
            System.out.print("Masukkan panjang: ");
            panjang = scanner.nextDouble();
            System.out.print("Masukkan lebar: ");
            lebar = scanner.nextDouble();
            luasPersegiPanjang = hitungLuasPersegiPanjang(panjang, lebar);
            System.out.println("Luas persegi panjang: " + luasPersegiPanjang);
        } else if (pilih == 3) {
            System.out.print("Masukkan alas: ");
            alas = scanner.nextDouble();
            System.out.print("Masukkan tinggi: ");
            tinggi = scanner.nextDouble();
            luasSegitiga = hitungLuasSegitiga(alas, tinggi);
            System.out.println("Luas segitiga: " + luasSegitiga);
        } else if (pilih == 4) {
            System.out.print("Masukkan alas: ");
            alasJang = scanner.nextDouble();
            System.out.print("Masukkan tinggi: ");
            tinggiJang = scanner.nextDouble();
            luasJajargenjang = hitungLuasJajargenjang(alasJang, tinggiJang);
            System.out.println("Luas jajar genjang: " + luasJajargenjang);
        } else if (pilih == 5) {
            System.out.print("Masukkan jari-jari: ");
            jari = scanner.nextDouble();
            luasLingkaran = hitungLuasLingkaran(jari, phi);
            System.out.println("Luas lingkaran: " + luasLingkaran);
        } else {
            System.out.println("Pilihan tidak ada.");
        }

        scanner.close();
    }

    public static double hitungLuasPersegi(double sisi) {
        return sisi * sisi;
    }

    public static double hitungLuasPersegiPanjang(double panjang, double lebar) {
        return panjang * lebar;
    }

    public static double hitungLuasSegitiga(double alas, double tinggi) {
        return alas * tinggi / 2;
    }

    public static double hitungLuasJajargenjang(double alasJang, double tinggiJang) {
        return alasJang * tinggiJang;
    }

    public static double hitungLuasLingkaran(double jari, float phi) {
        return phi * jari * jari;
    }
}
