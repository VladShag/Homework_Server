import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8087;
        try{
            try {
                clientSocket = new Socket(host, port);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                out.write("New client! \n");
                out.flush();
                System.out.println("Для ответов вводите здесь!");
                String name = reader.readLine();
                out.write(name + "\n");
                out.flush();
                String yesOrNot = reader.readLine();
                out.write(yesOrNot + "\n");
                out.flush();
            } finally {
                System.out.println("Client closed!");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
