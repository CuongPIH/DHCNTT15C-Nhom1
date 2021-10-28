package Bai08;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            DatagramSocket s = new DatagramSocket();
            InetAddress server = InetAddress.getByName("localhost");
            String str;

            Scanner sc = new Scanner(System.in);
            System.out.println("OP oper1 oper2\\n");
            System.out.println("Nhap khuon dang len: ");
            str = sc.nextLine();

            DatagramPacket dp_send = new DatagramPacket(str.getBytes(), str.length(),server, 7777);
            s.send(dp_send);
            System.out.println("Dui du lieu thanh cong");


            byte nhan[] = new byte[6000];
            DatagramPacket dp = new DatagramPacket(nhan, nhan.length);
            s.receive(dp);
            System.out.println("Server >> " + new String(dp.getData(), 0, dp.getLength()));
            
        }catch(Exception e){

        }
    }
}

