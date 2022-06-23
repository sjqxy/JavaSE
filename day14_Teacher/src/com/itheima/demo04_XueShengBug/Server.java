package com.itheima.demo04_XueShengBug;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(4444);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        System.out.println(new String(bytes, 0, length));
        datagramSocket.close();
    }
}
