import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_3 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)){
            Socket socket = server.accept();

            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("HTTP/1.1 200 Accepted\r\n");
            writer.write("\r\n");
            writer.write("hellow");
            writer.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
