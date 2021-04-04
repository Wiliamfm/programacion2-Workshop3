package model;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements Runnable {

  public ServerSocket servidor;

  @Override
  public void run() {
    try {
      servidor = new ServerSocket(1001);
      System.out.println("Chat Server created.");
      while (true) {
        Socket s = servidor.accept();
        DataInputStream inputData = new DataInputStream(s.getInputStream());
        String m = inputData.readUTF();
        System.out.println("Entrada al servidor del chat: " + m);
        inputData.close();
        s.close();
      }
    } catch (IOException e) {
      System.out.println("Cannot create server Socket: " + e.getMessage());
    }
  }

}
