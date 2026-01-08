import java.util.Scanner;

public class Opgaver1 {

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
        double a = readNonNegative("Enter a: ");
        double b = readNonNegative("Enter b: ");

        double c = Math.sqrt(a * a + b * b);
        double area = 0.5 * a * b;

        System.out.println("Hypotenuse c = " + c);
        System.out.println("Area = " + area);
    }

    static double readNonNegative(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!input.hasNextDouble()) {
                input.next();
                System.out.println("Invalid input. Enter a number.");
                continue;
            }
            double x = input.nextDouble();
            if (x < 0) {
                System.out.println("Illegal value: must be non-negative.");
                continue;
            }
            return x;
        }
    }

    static void close() {
        input.close();
    }
}
