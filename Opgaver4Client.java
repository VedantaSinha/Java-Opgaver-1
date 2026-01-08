import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgaver4Client {

    static final String HOST = "127.0.0.1";
    static final int PORT = 1068;

    static Scanner input;

    public static void main(String[] args) throws Exception {
        setup();
        run();
        close();
    }

    static void setup() {
        input = new Scanner(System.in);
    }

    static void run() throws Exception {
        System.out.print("Enter text: ");
        String text = input.nextLine();

        Socket sock = new Socket(HOST, PORT);

        BufferedReader netIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter netOut = new PrintWriter(sock.getOutputStream(), true);

        netOut.println(text);

        String reply = netIn.readLine();
        System.out.println("Reversed: " + reply);

        sock.close();
    }

    static void close() {
        input.close();
    }
}
