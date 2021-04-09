package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer implements Runnable {

  public ServerSocket servidor;
  private ArrayList<String> agents;
  private ArrayList<String> clients;

  @Override
  public void run() {
    try {
      servidor = new ServerSocket(1001);
      agents = new ArrayList<String>();
      clients = new ArrayList<String>();
      System.out.println("Chat Server created.");
      while (true) {
        Socket s = servidor.accept();
        String ipAddress = s.getInetAddress().getHostAddress();
        DataInputStream inputData = new DataInputStream(s.getInputStream());
        String a = inputData.readUTF();
        System.out.println("Entrada al chat: " + a);
        Socket send;
        DataOutputStream sendData;
        String[] m = a.split(",");
        switch (m[1]) {
        case "c":
          try {
            if (m[0].equals("message-..-")) {
              if (agents.size() == 0) {
                send = new Socket(ipAddress, 1003);
                sendData = new DataOutputStream(send.getOutputStream());
                sendData.writeUTF("No hay agentes conectados");
                send.close();
                sendData.close();
              } else {
                for (String agentAddress : agents) {
                  send = new Socket(agentAddress, 1002);
                  sendData = new DataOutputStream(send.getOutputStream());
                  sendData.writeUTF(m[0]);
                  send.close();
                  sendData.close();
                }
                if (clients.indexOf(ipAddress) == -1) {
                  clients.add(ipAddress);
                } else {
                  System.out.println("Client already in queue");
                }
              }
            } else {
              // Other message input from client?
            }
          } catch (IOException e) {
            System.out.println("Error in input client message: " + e.getMessage());
          }
          break;
        case "a":
          if (m[0].equals("StartConnection-..-")) {
            if (agents.indexOf(ipAddress) == -1) {
              agents.add(ipAddress);
              System.out.println("Agente conectado: " + ipAddress);
            } else {
              System.out.println("El agente: " + ipAddress + " ya se encuentra conectado");
            }
          } else if (m[0].equals("AceptaR-..-")) {
            // stablish connection with client
            send = new Socket(ipAddress, 1002);
            sendData = new DataOutputStream(send.getOutputStream());
            sendData.writeUTF(clients.get(0));
            send.close();
            sendData.close();
            send = new Socket(clients.get(0), 1003);
            sendData = new DataOutputStream(send.getOutputStream());
            sendData.writeUTF(ipAddress);
            send.close();
            sendData.close();
            clients.remove(0);
            agents.remove(ipAddress);
          } else if (m[0].equals("DeneGado-..-")) {
            // denegated connection from agent

          } else {
            // Other message input from agent?
          }
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
