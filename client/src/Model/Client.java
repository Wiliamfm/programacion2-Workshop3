package model;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Client
 */
public class Client extends Thread {

  public String message;

  public void sendMessage(String message, int host) {
    try {
      Socket s = new Socket("192.168.0.105", host);
      DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
      dataOut.writeUTF(message);
      dataOut.close();
      s.close();
    } catch (IOException e) {
      System.out.println("Error during socket client " + e.getMessage());
    }
  }

  public void serverChat() {
    try {
      ServerSocket server = new ServerSocket(1002);
      Socket sc = server.accept();
      DataInputStream inputChatData = new DataInputStream(sc.getInputStream());
      message = inputChatData.readUTF();
      System.out.println("\t Agente: " + message);
      inputChatData.close();
      sc.close();
      server.close();
    } catch (Exception e) {
      System.out.println("Cannot create server Socket: " + e.getMessage());
    }
  }

  public void run() {
    while (true) {
      serverChat();
    }
  }

}