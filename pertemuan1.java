public class pertemuan1 {
    public static void main(String[] args) {

      //mendeklarasikan variabel dan nilai
      int[] scores = {80, 70, 90, 60, 85, 75, 95, 65};
  
      //mendeklarasikan variabel boolean untuk menyimpan nilai
      boolean[] passResults = new boolean[scores.length];
  
      //mendeklarasikan skor keberhasilan
      int passingScore = 70;
  
      //menentukan hasil
      for (int i = 0; i < scores.length; i++) {
        if (scores[i] >= passingScore) {
          passResults[i] = true;
        } else {
          passResults[i] = false;
        }
      }
  
      //mencetak hasil
      System.out.println("Exam Scores:");
      for (int i = 0; i < scores.length; i++) {
        System.out.println("Score " + (i + 1) + ": " + scores[i] + " = " + (passResults[i] ? "PASS" : "FAIL"));
      }
    }
  }
//Nama : AdityaFernandoBuulolo
