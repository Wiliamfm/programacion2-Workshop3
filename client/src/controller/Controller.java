package controller;

import model.Client;
import model.ManageCasesFiles;

import java.util.Scanner;

public class Controller {

  private Client c;
  private Scanner sc;

  public Controller() {
    sc = new Scanner(System.in);
    boolean o = true;
    while (o) {
      try {
        System.out.println("\nBienvenidos a Ciudadanos de 4 Patas \n\n1.Crear Caso. \n2.Hablar con agente. \n3.Salir.");
        switch (sc.nextLine()) {
        case "1":
          System.out.println(
              "\nEscoga un caso: \n1.Pérdida. \n2.Robo. \n3.Abandono. \n4.Animal Peligroso \n5.Manejo indebido en vía pública.");
          String ca = sc.nextLine();
          if (ca.equals("1") || ca.equals("2") || ca.equals("3") || ca.equals("4") || ca.equals("5")) {
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
            ManageCasesFiles f = new ManageCasesFiles(ca, specie, size, localidad, addres, name, cel, email, comments);
            System.out.println("Su caso ha sido registrado con éxito.");
          } else {
            System.out.println("Entrada no válida: " + ca);
          }
          break;
        case "2":
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
