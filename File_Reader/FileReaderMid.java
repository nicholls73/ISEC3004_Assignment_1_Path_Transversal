import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderMid {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Prompt the user for the file name
            System.out.print("\nDISPLAY CONTENTS OF FILE IN CURRENT DIRECTORY\n\n\u001B[34mFILE NAME:\u001B[0m\n    ");
            String fileName = sc.next();

            // Get the canonical file path.
            File file = new File(fileName).getCanonicalFile();

            // Get the file's path and check if it is within the program's file (File_Reader).
            if (file.getPath().contains("File_Reader")) { // If file is within the program's file.
                Scanner reader = new Scanner(file);

                // Print the contents of the file
                System.out.println("\n\u001B[34mFILE CONTENTS:\u001B[0m");
                while (reader.hasNextLine()) {
                    System.out.println("    " + reader.nextLine());
                }
                System.out.println();
                reader.close();
            } else { // If the file is NOT within the program's file.
                System.out.println("\u001B[31mINVALID FILE NAME\u001B[0m");
            }
        } catch (IOException e) {
            System.out.println("\n\u001B[31mERROR READING FILE: \u001B[0m" + e.getMessage());
        }
    }
}