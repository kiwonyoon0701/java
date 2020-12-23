import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MadPlay {

  MadPlay() {
    String zipFileName = "./file.zip";
    String files = "a.txt";

    byte[] buf = new byte[4096];
    try {
      ZipOutputStream out = new ZipOutputStream(
        new FileOutputStream(zipFileName)
      );
      FileInputStream in = new FileInputStream(files);
      Path p = Paths.get(files);
      String fileName = p.getFileName().toString();

      ZipEntry ze = new ZipEntry(fileName);
      out.putNextEntry(ze);

      int len;
      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }

      out.closeEntry();
      in.close();

      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    //new MadPlay().zipExample();
    new MadPlay();
  }
}
