package ru.kpnn.dev.cesend;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Listener {
    private String _address = "127.0.0.1";
    private int _port = 3306;

    protected void main(){
       /* InetAddress ipAddress = InetAddress.getByName(_address);

        Socket socket = new Socket(ipAddress, _port);

        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();

        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);*/

        try {
            InetAddress ipAddress = InetAddress.getByName(_address); // создаем объект который отображает вышеописанный IP-адрес.

            Socket socket = new Socket(ipAddress, _port); // создаем сокет используя IP-адрес и порт сервера.

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;

            while (true) {
                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                saveData(line);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    protected void saveData(String str){

    }

    protected int send(String messege){
        try {
            InetAddress ipAddress = InetAddress.getByName(_address); // создаем объект который отображает вышеописанный IP-адрес.

            Socket socket = new Socket(ipAddress, _port); // создаем сокет используя IP-адрес и порт сервера.

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            out.writeUTF(messege); // отсылаем введенную строку текста серверу.
            out.flush(); // заставляем поток закончить передачу данных.
            return 0;

        } catch (Exception x) {
            x.printStackTrace();
            return 1;
        }
    }
}
