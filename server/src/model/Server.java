package model;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

  public ServerSocket servidor;

  public Server() {
  }

  @Override
  public void run() {
    try {
      servidor = new ServerSocket(1000);
      System.out.println("Server created.");
      while (true) {
        Socket s = servidor.accept();
        DataInputStream inputData = new DataInputStream(s.getInputStream());
        String m = inputData.readUTF();
        System.out.println("Entrada al servidor: " + m);
        s.close();
      }
    } catch (IOException e) {
      System.out.println("Cannot create server Socket: " + e.getMessage());
    }
  }
}
