import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)){
            System.out.println("wait connect...");
            Socket socket  = server.accept();
            socket.setSoTimeout(3000);// ms
            System.out.println("client success connect,IP:"+socket.getInetAddress().getHostAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("load client data:");
            System.out.println(reader.readLine());

            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("receive\n");
            writer.flush();
//            socket.close();
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
