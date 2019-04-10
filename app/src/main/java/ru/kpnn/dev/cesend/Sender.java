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

public class Sender {
    private String _address = "127.0.0.1";
    private int _port = 3306;

    protected void send(String messege){
        try {
            InetAddress ipAddress = InetAddress.getByName(_address); // создаем объект который отображает вышеописанный IP-адрес.

            Socket socket = new Socket(ipAddress, _port); // создаем сокет используя IP-адрес и порт сервера.

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            // Создаем поток для чтения с клавиатуры.
            //BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
            System.out.println();

            while (true) {

                out.writeUTF(messege); // отсылаем введенную строку текста серверу.
                out.flush(); // заставляем поток закончить передачу данных.
                break;
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
