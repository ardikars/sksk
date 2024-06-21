//ALIYA ROHAYA SIREGAR

import java.util.Scanner;
public class Tugas1 {
    public static void main(String[] args) {
         System.out.println("=== Program Perhitungan Nilai Rata-Rata SD==== ");
         System.out.println("Jika Nilai Rata-Rata Mahasiswa di bawah 50 = D, 51-69 = C, 70-79 = B, 80-100= A");
         Scanner scanner=new Scanner(System.in);
         System.out.print("Masukkan Nama Siswa :");
         String name= scanner.nextLine();  
         System.out.print("Nilai Bhs.Indonesia:");
         int a=scanner.nextInt();
         System.out.print("Nilai MTK:");
         int b=scanner.nextInt();
         System.out.print("Nilai Bhs.Inggris:");
         int c=scanner.nextInt();
         System.out.print("Nilai PKN:");
         int d=scanner.nextInt();
         System.out.print("Nilai IPA:");
         int e=scanner.nextInt();
         

         System.out.println("Nama :"+name);
         double average=(double)(a+b+c+d+e)/5;
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