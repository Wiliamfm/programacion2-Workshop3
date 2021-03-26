package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ManageCasesFiles {

  public ManageCasesFiles(String ca, String specie, String size, String localidad, String addres, String name,
      String cel, String email, String comments) {
    if (validateData(specie, size, localidad, addres, name, cel, email, comments)) {
      manageCSV(ca, specie, size, localidad, addres, name, cel, email, comments);
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

  private void manageCSV(String ca, String specie, String size, String localidad, String addres, String name,
      String cel, String email, String comments) {
    try {
      File f = new File("./data/cases4Pets.csv");
      FileWriter w = new FileWriter(f, true);
      BufferedWriter bw = new BufferedWriter(w);
      bw.newLine();
      if (!f.exists()) {
        f.createNewFile();
        bw.write("date,hour,case,specie,size,locality,addres,name,phone,email,comments\n");
      }
      String separetor = ",";
      bw.write(String.valueOf(java.time.LocalDate.now()) + separetor + String.valueOf(java.time.LocalTime.now())
          + separetor + ca + separetor + specie + separetor + size + separetor + localidad + separetor + addres
          + separetor + name + separetor + cel + separetor + email + separetor + comments);
      bw.close();
    } catch (Exception e) {
      System.out.println("error in file: " + e.getMessage());
    }
  }

}