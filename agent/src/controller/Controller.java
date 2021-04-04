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
    while (true) {
      a.serverChat();
      if (a.message.equals("message-..-")) {
        System.out.println("¿Desea conectarse con el cliente? \n1. Aceptar \n2. Denegar");
        switch (sc.nextLine()) {
        case "1":
          a.sendMessage("AceptaR-..-");
          a.start();
          while (a.isAlive()) {
            a.sendMessage(sc.nextLine());
          }
        case "2":
          System.out.println("No se estableció conexión");
          a.sendMessage("DeneGado-..-");
          break;
        default:
          System.out.println("Entrada no válida");
          break;
        }
      }
    }
  }

}