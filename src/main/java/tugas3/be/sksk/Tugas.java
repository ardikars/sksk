package tugas3.be.sksk;/*
* TUGAS SKSK PROGRAM SEDERHANA
*
* SHOW LIST MENU
* 1. Cek Tipe Data
* 2. Komparasi 2 Angka
* 3. Kalkulator Sederhana
*
* ARBI DWI WIJAYA - BE BATCH 23
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tugas {

    public static void main(String[] args) {
        viewShowTodoList();
    }

    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    private static final Map<String, Class<?>> PRIMITIVE_TYPES = new HashMap<>();
    static {
        PRIMITIVE_TYPES.put("byte", byte.class);
        PRIMITIVE_TYPES.put("short", short.class);
        PRIMITIVE_TYPES.put("int", int.class);
        PRIMITIVE_TYPES.put("long", long.class);
        PRIMITIVE_TYPES.put("float", float.class);
        PRIMITIVE_TYPES.put("double", double.class);
        PRIMITIVE_TYPES.put("char", char.class);
        PRIMITIVE_TYPES.put("boolean", boolean.class);
    }
    public static boolean isPrimitiveType(String typeName) {
        return PRIMITIVE_TYPES.containsKey(typeName);
    }

    public static void showTodoList() {
        System.out.println("===== LIST =====");
        for(var i = 0; i < model.length; i++) {
            var todo = model[i];
            var number = i + 1;

            if(todo != null) {
                System.out.println(number + ". " + todo);
            }
        }
    }

    public static void cekTipeData(String tipedata) {
        if (isPrimitiveType(tipedata)) {
            System.out.println(tipedata + " adalah tipe data primitif.");
        } else {
            System.out.println(tipedata + " bukan tipe data primitif.");
        }
    }

    public static void cekKomparasiAngka(int angkaPertama, int angkaKedua) {
        if (angkaPertama > angkaKedua) {
            System.out.println("Angka " + angkaPertama + " lebih besar daripada angka " + angkaKedua);
        } else if (angkaPertama < angkaKedua) {
            System.out.println("Angka " + angkaPertama + " lebih kecil daripada angka " + angkaKedua);
        } else {
            System.out.println("Angka " + angkaPertama + " sama dengan angka " + angkaKedua);
        }
    }

    public static void kalkulatorSederhana(int angkaPertama, int angkaKedua) {
        int jumlah = angkaPertama + angkaKedua;
        int kurang = angkaPertama - angkaKedua;
        double bagi = (double) angkaPertama / angkaKedua;
        int kali = angkaPertama * angkaKedua;
        int modulo = angkaPertama % angkaKedua;

        System.out.println("Hasil ================== ");
        System.out.println("Penjumlahan : " + jumlah);
        System.out.println("Pengurangan : " + kurang);
        System.out.println("Pembagian : " + bagi);
        System.out.println("Perkalian : " + kali);
        System.out.println("Sisa Bagi : " + modulo);
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }

    public static void viewShowTodoList() {
        label:
        while (true) {
            showTodoList();

            System.out.println("Menu: ");
            System.out.println("1. Cek Tipe Data");
            System.out.println("2. Komparasi Angka");
            System.out.println("3. Kalkulator");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            switch (input) {
                case "1":
                    viewCekTipeData();
                    break;
                case "2":
                    viewKomparasiAngka();
                    break;
                case "3":
                    viewKalkulatorSederhana();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println("Pilihan tidak ditemukan!");
                    break;
            }
        }
    }

    public static void viewCekTipeData() {
        System.out.println("CEK TIPE DATA");

        var tipedata = input("Masukkan tipe data");

        cekTipeData(tipedata);
    }

    public static void viewKomparasiAngka() {
        System.out.println("CEK PERBANDINGAN ANGKA");

        var angkaPertama = input("Masukkan angka pertama");
        var angkaKedua = input("Masukkan angka kedua");

        cekKomparasiAngka(Integer.parseInt(angkaPertama), Integer.parseInt(angkaKedua));
    }

    public static void viewKalkulatorSederhana() {
        System.out.println("===== Kalkulator Sederhana =====");

        var angkaPertama = input("Masukkan angka pertama");
        var angkaKedua = input("Masukkan angka kedua");

        kalkulatorSederhana(Integer.parseInt(angkaPertama), Integer.parseInt(angkaKedua));
    }
}
