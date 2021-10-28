package Bai05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            DatagramSocket s = new DatagramSocket();
            String str;
            Scanner sc = new Scanner(System.in);
            do{
                System.out.println("----------Menu----------");
                System.out.println("Chọn chức năng:");
                System.out.println("1. Time");
                System.out.println("2. Date");
                System.out.println("3.Date time");
                System.out.println("0. Exit");
                InputStreamReader is = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(is);
                System.out.println("lựa chọn: ");
                str = br.readLine();
                byte data[] = str.getBytes();
                DatagramPacket pkt = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 7777);
                s.send(pkt);

                byte[] arr = new byte[6000];
                DatagramPacket nhan = new DatagramPacket(arr, arr.length);
                s.receive(nhan);
                String fromServer = new String(nhan.getData(), 0, nhan.getLength());
                System.out.println("Server trả về >>" + fromServer);

            }while(str != "0");
        }catch(Exception e){
            
        }
    }
}