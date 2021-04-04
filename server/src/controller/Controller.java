package controller;

import model.ChatServer;
import model.Server;

public class Controller {

  private Server server;
  private ChatServer cServer;

  public Controller() {
    server = new Server();
    Thread serverT = new Thread(server);
    serverT.start();
    cServer = new ChatServer();
    Thread cServerT = new Thread(cServer);
    cServerT.start();
  }
}
