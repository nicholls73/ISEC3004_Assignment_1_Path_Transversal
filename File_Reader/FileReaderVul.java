import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderVul {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Prompt the user for the file name
            System.out.print("\nDISPLAY CONTENTS OF FILE IN CURRENT DIRECTORY\n\n\u001B[34mFILE NAME:\u001B[0m\n    ");
            String fileName = sc.next();

            // Create a File object for the specified file name
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            // Print the contents of the file
            System.out.println("\n\u001B[34mFILE CONTENTS:\u001B[0m");
            while (reader.hasNextLine()) {
                System.out.println("    " + reader.nextLine());
            }
            System.out.println();
            reader.close();
        } catch (IOException e) {
            System.out.println("\n\u001B[31mERROR READING FILE: \u001B[0m" + e.getMessage());
        }
    }
}