package tugas_1;

import java.util.*;

// Annur Akbar Bahagia
// BE(Java) SKSK Batch 23

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========>Mini Program<=========");
        System.out.println("1. Mini Kalkulator");
        System.out.println("2. Estimasi Waktu Perjalanan");
        System.out.print("Pilih Program :");
        String plih = scanner.next();

        switch(plih){
            case "1":{
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
                System.out.println("Hasil = "+calc.calc(oprasi, nilai, nilai2)); 
                break;
            }
            case "2":{
                estimasiWaktu estimateTime = new estimasiWaktu();
                System.out.print("Jarak tempuh :");
                int jarak = scanner.nextInt();
                
                System.out.print("Kecepatan :");
                int kecepatan = scanner.nextInt(); 

                System.out.println("Estimasi Waktu tempuh = " + estimateTime.estimateTime(jarak, kecepatan)+" Jam");
            }
        }

        scanner.close();
    }
}

class kalkulator{
    private int result;

    // Calculator Function
    public int calc(String opration,int nilai,int nilai2){

        switch(opration){
            case "+":{
                result = nilai+nilai2;
                break;
            }
            case "-":{
                result = nilai-nilai2;
                break;
            }
            case "/":{
                result = nilai2 == 0 ? 0 : nilai+nilai2;
                break;
            }
            case "x":{
                result = nilai*nilai2;
                break;
            }
            case "%":{
                result = nilai%nilai2;
                break;
            }
            default:{
                System.out.println("Oprasi Tidak Valid");
            }
        }
        return result;
    }
}

class estimasiWaktu{

    private float result = 0;

    public float estimateTime(int jarak,int kecepatan) {
       if(jarak == 0 || kecepatan == 0){
        System.out.println("input kecepatan dan jarak dengan benar");
       }else{
        result = jarak/kecepatan;
       }

        return result;
    }
}
