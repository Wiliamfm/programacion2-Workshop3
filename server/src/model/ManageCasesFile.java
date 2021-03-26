package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ManageCasesFile {

  public ManageCasesFile(String m) {
    manageCSV(m);
  }

  private void manageCSV(String m) {
    try {
      File f = new File("./data/cases4Pets.csv");
      FileWriter w = new FileWriter(f, true);
      BufferedWriter bw = new BufferedWriter(w);
      if (!f.exists()) {
        f.createNewFile();
        bw.write("date,hour,case,specie,size,locality,addres,name,phone,email,comments");
      }
      bw.newLine();
      bw.write(m);
      bw.close();
    } catch (Exception e) {
      System.out.println("error in file: " + e.getMessage());
    }
  }

}