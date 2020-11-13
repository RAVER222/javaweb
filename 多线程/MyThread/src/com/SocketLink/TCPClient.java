package com.SocketLink;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        while (true) {
            //1.创建Socket对象
            Socket s = new Socket("127.0.0.1", 9999);
            //2.从连接中取出输出流并发信息
            OutputStream os = s.getOutputStream();
            System.out.println("请输入:");
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.nextLine();
            os.write(msg.getBytes());


            //3.从连接中取出输入流并接受会话
            InputStream is = s.getInputStream();
            byte[] b = new byte[20];
            is.read(b);
            System.out.println("老板说:"+new String(b).trim());
            //关闭
            s.close();

        }
    }
}