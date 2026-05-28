package app.tp2.ex8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class Copie {
  public static void main() {
    try (var fis = new BufferedInputStream(new FileInputStream("WHR26.pdf"));
        var fos = new BufferedOutputStream(new FileOutputStream("WHR27.pdf"))) {
      int b = fis.read();
      while (b != -1) {
        fos.write(b);
        b = fis.read();
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
