package controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import model.ChatServer;
import model.Server;

public class Controller {

  private Server server;
  private ChatServer cServer;

  public Controller() throws UnknownHostException {
    System.out.println("Servidor inicializado en: " + InetAddress.getLocalHost().getHostAddress());
    server = new Server();
    Thread serverT = new Thread(server);
    serverT.start();
    cServer = new ChatServer();
    Thread cServerT = new Thread(cServer);
    cServerT.start();
  }
}
