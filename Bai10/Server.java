package Bai10;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Server {
    private final static int port = 7777;
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("UDP SERVER DA DUOC TAO");
            Scanner sc = new Scanner(System.in);
            while(true){

                byte[] inputByte = new byte[6000];
                DatagramPacket inputPack = new DatagramPacket(inputByte, inputByte.length);
                socket.receive(inputPack);
                String inputStr = new String(inputPack.getData(), 0, inputPack.getLength());
                String inputStr_ND = inputStr.substring(12).trim();
                String inputStr_fileName = inputStr.substring(0,12).trim();

                System.out.println("Noi dung nhan duoc : " + inputStr_ND );

                ghifile(inputStr_ND,inputStr_fileName);

                System.out.println("Ban noi: ");
                String str1 = sc.nextLine();
                DatagramPacket gui = new DatagramPacket(str1.getBytes(), str1.length(), inputPack.getAddress(), inputPack.getPort());
                socket.send(gui);
            }
        } catch (Exception e) {
        }
    }

    public static void ghifile(String inputStr, String fileName) throws IOException{
        try {
            File file =new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            Date dNow = new Date( );
            SimpleDateFormat ti = new SimpleDateFormat ("hh:mm:ss");

            pw.println("(" + ti.format(dNow) + ")" + inputStr);
            pw.close();

            System.out.println("GHI FILE THANH CONG");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
