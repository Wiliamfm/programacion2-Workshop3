package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Agent extends Thread {

  public final String serverAddress = "172.20.0.1";
  public String message = "";
  public String clientAddress = "";

  public Agent() {

  }

  public void sendMessage(String message, String address, int host, int t) {
    try {
      Socket s = new Socket(address, host);
      DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
      switch (t) {
      case 1:
        dataOut.writeUTF(message);
        break;
      case 2:
        String sep = ",";
        String m = message + sep + "a";
        dataOut.writeUTF(m);
        break;
      default:
        break;
      }
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
      System.out.println("\t CLIENTE: " + message);
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