package TCPSocket;

import java.io.*;
import java.net.*;

public class Xuly extends Thread {
    Socket s;
    public Xuly(Socket s) {
        this.s = s;
    }
    public void run() {
        try {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            while (true) {
                int ch = is.read();
                System.out.println((char) ch);
                if (ch == -1)
                    break;
                os.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
