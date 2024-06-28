import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String noteContent;
        String fileName;
        String userAnswer;
        System.out.println("do you want write a new note or continue the existing, please type 'new' or 'existing'");
        userAnswer = scanner.nextLine();

        if(userAnswer.equals("new")){
            System.out.println("What do you want to write");
            noteContent = scanner.nextLine();
            System.out.println("name of the file");
            fileName = scanner.nextLine();
            scanner.close();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName+".txt"));
                writer.write(noteContent);
                writer.close();
                System.out.println(fileName+".txt is created");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } else if(userAnswer.equals("existing")) {
            System.out.println("existing");
            System.out.println("name of the file");
            fileName = scanner.nextLine();
            File file = new File(fileName+".txt");
            if(file.exists()){
                System.out.println("file exists");
                System.out.println("What do you want to write");
                noteContent = scanner.nextLine();
                scanner.close();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                    writer.write("\n" + noteContent);
                    writer.close();
                    System.out.println(file+" is updated");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else {
                System.out.println("file does not exist");
            }
        }

        System.out.println("aps is finished");
    }
}
