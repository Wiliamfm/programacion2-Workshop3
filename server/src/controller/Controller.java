package controller;

import model.Server;

public class Controller {

  private Server server;

  public Controller() {
    server = new Server();
    Thread serverT = new Thread(server);
    serverT.run();
  }

}
