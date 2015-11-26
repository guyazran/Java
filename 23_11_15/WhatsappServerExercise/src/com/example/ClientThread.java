package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created by guyazran on 11/26/15.
 */
public class ClientThread extends Thread {

    Socket clientSocket;
    InputStream inputStream;
    OutputStream outputStream;

    public ClientThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        inputStream = null;
        outputStream = null;
        try {
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            byte[] buffer = new byte[1024];
            int actuallyRead;
            System.out.println("client connected");
            StringBuilder stringBuilder = new StringBuilder();
            int x = 0;
            long y = 0;
            while ((actuallyRead = inputStream.read(buffer)) != -1){
                //String s = new String(buffer, 0, actuallyRead);
                //stringBuilder.append(s);
                //x = ByteBuffer.wrap(buffer, 0, actuallyRead).getInt();
                y = ByteBuffer.wrap(buffer, 0, actuallyRead).getLong();
                System.out.println(y);

                break;
            }

            //ByteBuffer.wrap(buffer, 8, 4).putInt(13);
            //outputStream.write(buffer, 0, actuallyRead + 4);

            outputStream.write("some response from the server".getBytes());

            //System.out.println(stringBuilder.toString());
            //System.out.println(x);
            System.out.println(y);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (clientSocket != null){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
