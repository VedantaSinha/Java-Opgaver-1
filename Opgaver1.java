import java.util.Scanner;

class RightTriangle {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = input.nextDouble();

        System.out.print("Enter b: ");
        double b = input.nextDouble();

        if (a < 0 || b < 0) {
            System.out.println("Illegal value: a and b must be non-negative.");
            return;
        }

        double c = Math.sqrt(a * a + b * b);
        double area = 0.5 * a * b;

        System.out.println("Hypotenuse c = " + c);
        System.out.println("Area = " + area);
    }
}
