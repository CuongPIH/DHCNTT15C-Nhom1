package Bai08;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
        try{
            DatagramSocket s = new DatagramSocket(7777);
            System.out.println("Server UDP đã được tạo!");
            //nhan
            byte n[] = new byte[6000];
            DatagramPacket dp = new DatagramPacket(n,n.length);
            s.receive(dp);
            String strnhan = new String(dp.getData(),0,dp.getLength());
            String str = strnhan.substring(0, strnhan.indexOf("\\n"));
            System.out.println(str);
            String kq;
            String op = str.split(" ")[0];
            double oper1 = Integer.parseInt(str.split(" ")[1]);
            double oper2 = Integer.parseInt(str.split(" ")[2]);
            switch(op) {
                case "+": 
                    kq = oper1 + "+" + oper2 + "=" + (oper1 + oper2);
                case "-": 
                    kq = oper1 + "-" + oper2 + "=" + (oper1 - oper2);
                case "*": 
                    kq = oper1 + "*" + oper2 + "=" + (oper1 * oper2);
                case "/": 
                    kq = oper1 + "/" + oper2 + "=" + (oper1 / oper2);
                default: 
                    kq = "Nhập sai dữ liệu!";
                    break;
            }

            DatagramPacket dp_send = new DatagramPacket(kq.getBytes(),kq.length(),dp.getAddress(),dp.getPort());
            s.send(dp_send);
        }catch(Exception e){

        }
    }
}

