package controller;

import java.util.Scanner;

import model.Agent;

/**
 * Controller
 */
public class Controller {

  private Scanner sc;
  private Agent a;

  public Controller() {
    System.out.println("Bienvenido, espere hasta que un cliente solicite conexión");
    sc = new Scanner(System.in);
    a = new Agent();
    a.sendMessage("StartConnection-..-", a.serverAddress, 1001, 2);
    while (true) {
      a.serverChat();
      if (a.message.equals("message-..-")) {
        System.out.println("¿Desea conectarse con el cliente? \n1. Aceptar \n2. Denegar");
        switch (sc.nextLine()) {
        case "1":
          a.sendMessage("AceptaR-..-", a.serverAddress, 1001, 2);
          a.serverChat();
          if (a.message.equals("false")) {
            System.out.println("Ya no hay clientes conectados.");
          } else {
            a.clientAddress = a.message;
            System.out.println("Conexión establecida con el cliente: " + a.clientAddress);
            a.start();
            while (a.isAlive()) {
              a.sendMessage(sc.nextLine(), a.clientAddress, 1003, 1);
            }
          }
        case "2":
          System.out.println("No se estableció conexión");
          a.sendMessage("DeneGado-..-", a.serverAddress, 1001, 2);
          break;
        default:
          System.out.println("Entrada no válida");
          break;
        }
      }
    }
  }

}