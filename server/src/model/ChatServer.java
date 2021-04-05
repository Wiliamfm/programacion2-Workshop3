package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
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
        String a = inputData.readUTF();
        System.out.println("Entrada al chat: " + a);
        Socket send;
        DataOutputStream sendData;
        String[] m = a.split(",");
        switch (m[2]) {
        case "c":
          try {
            send = new Socket(m[0], 1002);
            sendData = new DataOutputStream(send.getOutputStream());
            sendData.writeUTF(m[1]);
          } catch (IOException e) {
            send = new Socket(m[0], 1003);
            sendData = new DataOutputStream(send.getOutputStream());
            sendData.writeUTF("No hay agentes disponibles");
          }
          break;
        case "a":
          send = new Socket(m[0], 1003);
          sendData = new DataOutputStream(send.getOutputStream());
          sendData.writeUTF(m[1]);
          break;
        default:
          break;
        }
        inputData.close();
        s.close();
      }
    } catch (IOException e) {
      System.out.println("Cannot create chat server Socket: " + e.getMessage());
    }
  }

}
