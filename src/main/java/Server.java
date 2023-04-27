import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static Socket clientSocket;
    private static ServerSocket serverSocket;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) {
        int port = 8087;
        serverSocket = null;
        try {
            try {
                serverSocket = new ServerSocket(port);
                try {
                    clientSocket = serverSocket.accept();
                    System.out.println("New connection accepted");
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    String clientName = in.readLine();
                    System.out.println(String.format("Hi %s, your port is %d", clientName, clientSocket.getPort()));
                    System.out.println("Write your name: ");
                    String name = in.readLine();
                    System.out.println("Are you a child? (yes/no) ");
                    String answer = in.readLine();
                    switch (answer) {
                        case "yes":
                            System.out.println("Welcome to the kids area, " + name + " ! Let's play!");
                            break;
                        case "no":
                            System.out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                            break;
                        default:
                            System.out.println("Sorry, you must say only yes or no");
                    }


                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Server closed");
                serverSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
