import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8080);
            Scanner scanner = new Scanner(System.in)){
            System.out.println("connect server");
            socket.setKeepAlive(true);
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write(scanner.nextLine()+"\n");
            writer.flush();
            System.out.println("data send!wait for server check...");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("receive server data:" + reader.readLine());

        }catch (IOException e){
            System.out.println("connect server error");
            e.printStackTrace();
        }
    }
}
