public class MainBagasSKSK {
    public static void main(String[] args){
        System.err.println("Hello World!");

        String firstName = "Bagas ";
        String lastName = "Sukma Patria";
        String fullName = firstName + lastName;
        System.out.println(fullName);

        int x = 16;
        int y = 20;
        if (x > y) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }

        String[] fruit = {"Apel", "Mango", "Grape", "Pear"};
        fruit[0] = "Banana";
        System.out.println(fruit[0]);
    }
}