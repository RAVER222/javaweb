package com.SocketLink;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPService {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);

        while(true)
        {
            System.out.println("来啊");
            Socket s =ss.accept();
            System.out.println("来啊");
            InputStream is = s.getInputStream();  //阻塞
            byte[] b = new byte[20];
            is.read(b);
            String clientIP =s.getInetAddress().getHostAddress();
            System.out.println(clientIP+"说"+new String(b).trim());
            //4.从连接中取出输出流并会话
            OutputStream os = s.getOutputStream();
            os.write("没有".getBytes());
            s.close();
        }
    }
}
