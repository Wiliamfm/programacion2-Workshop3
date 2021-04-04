package controller;

import model.Client;

import java.util.Scanner;

public class Controller {

  private Scanner sc;
  private Client c;

  public Controller() {
    sc = new Scanner(System.in);
    c = new Client();
    boolean o = true;
    while (o) {
      try {
        System.out.println("\nBienvenidos a Ciudadanos de 4 Patas \n\n1.Crear Caso. \n2.Hablar con agente. \n3.Salir.");
        switch (sc.nextLine()) {
        case "1":
          System.out.println(
              "\nEscoga un caso: \n1.Pérdida. \n2.Robo. \n3.Abandono. \n4.Animal Peligroso \n5.Manejo indebido en vía pública.");
          String ca = "";
          boolean bca = false;
          switch (sc.nextLine()) {
          case "1":
            ca = "Pérdida";
            bca = true;
            break;
          case "2":
            ca = "Robo";
            bca = true;
            break;
          case "3":
            ca = "Abandono";
            bca = true;
            break;
          case "4":
            ca = "Animal Peligroso";
            bca = true;
            break;
          case "5":
            ca = "Manejo Indebido";
            bca = true;
            break;
          default:
            System.out.println("Por favor escoga una de los casos anteriores.");
            bca = false;
            break;
          }
          if (bca) {
            System.out.println("Ingrese la especie de la mascota:");
            String specie = sc.nextLine();
            System.out.println("Ingrese el tamaño de la mascota:");
            String size = sc.nextLine();
            System.out.println("Ingrese la localidad de la mascota:");
            String localidad = sc.nextLine();
            System.out.println("Ingrese la dirección de la mascota:");
            String addres = sc.nextLine();
            System.out.println("Ingrese su NOMBRE COMPLETO:");
            String name = sc.nextLine();
            System.out.println("Ingrese su número telefónico:");
            String cel = sc.nextLine();
            System.out.println("Ingrese su e-mail:");
            String email = sc.nextLine();
            System.out.println("Ingrese comentarios generales:");
            String comments = sc.nextLine();
            if (specie.equalsIgnoreCase("canino") || specie.equalsIgnoreCase("felino")) {
              if (size.equalsIgnoreCase("miniatura") || size.equalsIgnoreCase("pequeño")
                  || size.equalsIgnoreCase("mediano") || size.equalsIgnoreCase("grande")
                  || size.equalsIgnoreCase("muy grande")) {
                String separetor = ",";
                String message = String.valueOf(java.time.LocalDate.now()) + separetor
                    + String.valueOf(java.time.LocalTime.now()) + separetor + ca + separetor + specie.toLowerCase()
                    + separetor + size.toLowerCase() + separetor + localidad + separetor + addres + separetor + name
                    + separetor + cel + separetor + email + separetor + comments;
                c.sendMessage(message, 1000);
                System.out.println("Su caso ha sido registrado con éxito.");
              }
            }
          } else {
            System.out.println("Entrada no válida");
          }
          break;
        case "2":
          System.out.println("Conectando con el agente...");
          c.sendMessage("message-..-", 1001);
          c.serverChat();
          if (c.message.equals("AceptaR-..-")) {
            System.out.println("Conexión establecida con el agente");
            c.start();
            while (c.isAlive()) {
              c.sendMessage(sc.nextLine(), 1001);
            }
          } else {
            System.out.println("El agente rechazó la conexión");
          }
          break;
        case "3":
          System.out.println("Ha salido del programa. Vuelva pronto");
          o = false;
          break;
        default:
          System.out.println("Por favor escoga una de las opciones anteriores ('1','2','3')");
          break;
        }
      } catch (Exception e) {
      }
    }
  }

}