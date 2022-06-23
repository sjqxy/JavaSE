package com.itheima.demo04_XueShengBug;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception {

        DatagramSocket datagramSocket = new DatagramSocket();
        String s = "111";
        byte[] bytes = s.getBytes();
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int i = 4444;
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetAddress, i);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
