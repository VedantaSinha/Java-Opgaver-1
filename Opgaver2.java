import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgaver2 {

    static Scanner input;

    public static void main(String[] args) {
        setup();
        run();
        close();
    }

    static void setup() {
        input = new Scanner(System.in);
    }

    static void run() {
        System.out.print("Enter filename (or full path): ");
        String filename = input.nextLine();

        try {
            int totalWords = countWords(filename);
            System.out.println("The file " + filename + " contains " + totalWords + " words.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    static int countWords(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        int total = 0;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
            if (!line.isEmpty()) {
                total += line.split("\\s+").length;
            }
        }

        fileScanner.close();
        return total;
    }

    static void close() {
        input.close();
    }
}
