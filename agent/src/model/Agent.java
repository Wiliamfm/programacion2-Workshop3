package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Agent extends Thread {

  public String message = "";

  public Agent() {

  }

  public void sendMessage(String message) {
    try {
      Socket s = new Socket("192.168.0.105", 1001);
      DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
      String sep = ",";
      String m = InetAddress.getLocalHost().getHostAddress() + sep + message + sep + "a";
      dataOut.writeUTF(m);
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
