package day1;

/**
 *
 * @author vicky ardiansyah
 */
public class Main {
    
    public static void main(String[] args) {
        int jumlahItem = 5;

        double hargaPerItem = 19.99;

        double pajak = 0.10;

        double totalSebelumPajak = jumlahItem * hargaPerItem;
        double totalSetelahPajak = totalSebelumPajak + (totalSebelumPajak * pajak);

        char simbolMataUang = '$';
        String totalSebagaiString = Double.toString(totalSetelahPajak);

        boolean diskonDiberikan = jumlahItem > 3;

        String[] namaItem = {"Item1", "Item2", "Item3", "Item4", "Item5"};
        System.out.println("Daftar Item di Keranjang:");
        for (String item : namaItem) {
            System.out.println(item);
        }

        String namaToko = new String("Toko Sederhana");

        double diskon = 0.0;
        if (diskonDiberikan) {
            diskon = totalSetelahPajak * 0.1;
        }
        double totalAkhir = totalSetelahPajak - diskon;

        boolean isTotalValid = totalAkhir > 0;

        int bitwiseAnd = jumlahItem & 1;
        int bitwiseOr = jumlahItem | 1;

        int unaryPositive = +jumlahItem;
        int unaryNegative = -jumlahItem;
        int preIncrement = ++jumlahItem;
        int postIncrement = jumlahItem++;
        int preDecrement = --jumlahItem;
        int postDecrement = jumlahItem--;

        String statusDiskon = diskonDiberikan ? "Diskon diberikan" : "Tidak ada diskon";

        // Output hasil
        System.out.println("Nama Toko: " + namaToko);
        System.out.println("Jumlah Item: " + jumlahItem);
        System.out.println("Harga per Item: " + simbolMataUang + hargaPerItem);
        System.out.println("Total sebelum pajak: " + simbolMataUang + totalSebelumPajak);
        System.out.println("Total setelah pajak: " + simbolMataUang + totalSetelahPajak);
        System.out.println("Diskon: " + simbolMataUang + diskon);
        System.out.println("Total akhir: " + simbolMataUang + totalAkhir);
        System.out.println("Status Diskon: " + statusDiskon);
        System.out.println("Total Valid: " + isTotalValid);

        System.out.println("Bitwise AND: " + bitwiseAnd);
        System.out.println("Bitwise OR: " + bitwiseOr);

        System.out.println("Unary Positive: " + unaryPositive);
        System.out.println("Unary Negative: " + unaryNegative);
        System.out.println("Pre Increment: " + preIncrement);
        System.out.println("Post Increment: " + postIncrement);
        System.out.println("Pre Decrement: " + preDecrement);
        System.out.println("Post Decrement: " + postDecrement);
    }
}
