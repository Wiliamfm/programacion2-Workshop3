package Model;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Client
 */
public class Client {

  private Socket s;

  public Client() {
    try {
      s = new Socket("192.168.0.1", 1000);
      DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
      dataOut.writeUTF("asdf");
      dataOut.close();
    } catch (IOException e) {
      System.out.println("Error during socket client " + e.getMessage());
    }
  }
}