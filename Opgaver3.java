import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opgaver3 {

    static Socket sock;
    static BufferedReader netIn;
    static PrintWriter netOut;
    static Scanner userIn;

    public static void main(String[] args) throws Exception {
        connect();
        play();
        close();
    }

    static void connect() throws Exception {
        sock = new Socket("34302.cyberteknologi.dk", 1060);
        netIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        netOut = new PrintWriter(sock.getOutputStream(), true);
        userIn = new Scanner(System.in);
        System.out.println(netIn.readLine());
    }

    static void play() throws Exception {
        while (true) {
            String line1 = netIn.readLine();
            if (line1 == null) break;

            String line2 = netIn.readLine();
            if (line2 == null) break;

            if (line1.startsWith("BOARD IS")) {
                printBoard(line1.substring(line1.length() - 9));
            }

            if (line2.equals("YOUR TURN")) {
                netOut.println(userIn.nextLine().charAt(0));
            }
            else if (line2.equals("ILLEGAL MOVE") || line2.equals("ILLEGAL INPUT")) {
                System.out.println(line2);
                System.out.println(netIn.readLine());
                netOut.println(userIn.nextLine().charAt(0));
            }
            else {
                System.out.println(line2);
                break;
            }
        }
    }

    static void printBoard(String b) {
        System.out.println("+---+---+---+");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("|" + (i+1) + "  |" + (i+2) + "  |" + (i+3) + "  |");
            System.out.println("| " + b.charAt(i) + " | " + b.charAt(i+1) + " | " + b.charAt(i+2) + " |");
            System.out.println("+---+---+---+");
        }
    }

    static void close() throws Exception {
        sock.close();
    }
}
