package TCPSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerSS {
    public static void main(String[] args) {
        ServerSocket ss;
        try {
            ss = new ServerSocket(6789);
            System.out.println("SERVER song song DA~ DUOC TAO");
            while (true) {
                Socket s = ss.accept();
                 Xuly p = new Xuly(s);
                p.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
