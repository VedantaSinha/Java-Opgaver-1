import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Opgaver4Server {

    static final int PORT = 1068;

    static ServerSocket serverSock;

    public static void main(String[] args) throws Exception {
        setup();
        run();
        close();
    }

    static void setup() throws Exception {
        serverSock = new ServerSocket(PORT);
        System.out.println("Server listening on port " + PORT);
    }

    static void run() throws Exception {
        while (true) {
            Socket sock = serverSock.accept();
            handleClient(sock);
        }
    }

    static void handleClient(Socket sock) throws Exception {
        BufferedReader netIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter netOut = new PrintWriter(sock.getOutputStream(), true);

        String line = netIn.readLine();
        if (line == null) {
            sock.close();
            return;
        }

        netOut.println(reverse(line));
        sock.close();
    }

    static String reverse(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
        }
        return new String(c);
    }

    static void close() throws Exception {
        serverSock.close();
    }
}

