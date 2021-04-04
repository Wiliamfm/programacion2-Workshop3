package controller;

import model.ChatServer;
import model.Server;

public class Controller {

  private Server server;
  private ChatServer cServer;

  public Controller() {
    server = new Server();
    cServer = new ChatServer();
    Thread serverT = new Thread(server);
    serverT.start();
    // Chat Server
    Thread cServerT = new Thread(cServer);
    cServerT.start();
  }

}
