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

  public final String serverAddress = "172.20.0.1";
  public String message;
  public String agentAddress = "";

  public boolean sendMessage(String message, String address, int host, int t) {
    try {
      Socket s = new Socket(address, host);
      DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
      switch (t) {
      case 1:
        dataOut.writeUTF(message);
        break;
      case 2:
        String sep = ",";
        String m = message + sep + "c";
        dataOut.writeUTF(m);
        break;
      default:
        break;
      }
      dataOut.close();
      s.close();
      return true;
    } catch (IOException e) {
      System.out.println("Error during socket client " + e.getMessage());
      return false;
    }
  }

  public void serverChat() {
    try {
      ServerSocket server = new ServerSocket(1003);
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