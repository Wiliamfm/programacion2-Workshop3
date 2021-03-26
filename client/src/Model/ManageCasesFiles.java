package model;

import java.io.File;

public class ManageCasesFiles {

  public ManageCasesFiles(String specie, String size, String localidad, String addres, String name, String cel,
      String email, String comments) {
    if (validateData(specie, size, localidad, addres, name, cel, email, comments)) {
      manageCSV(specie, size, localidad, addres, name, cel, email, comments);
    } else {
      System.out.println("Error validating data");
    }
  }

  private boolean validateData(String specie, String size, String localidad, String addres, String name, String cel,
      String email, String comments) {
    if (specie.equalsIgnoreCase("canino") || specie.equalsIgnoreCase("felino")) {
      if (size.equalsIgnoreCase("miniatura") || size.equalsIgnoreCase("pequeño") || size.equalsIgnoreCase("mediano")
          || size.equalsIgnoreCase("grande") || size.equalsIgnoreCase("muy grande")) {
        return true;
      }
    }
    return false;
  }

  private void manageCSV(String specie, String size, String localidad, String addres, String name, String cel,
      String email, String comments) {
    try {
      File f = new File("./data/cases4Pets.csv");
    } catch (Exception e) {
      System.out.println("error in file" + e.getMessage());
    }
  }

}