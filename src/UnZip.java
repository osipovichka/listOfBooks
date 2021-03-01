import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZip {

    public static String unZip(String file, String pathToFile) throws IOException {

        ZipInputStream zip = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry;
        String nameFile;

        while ((entry = zip.getNextEntry()) != null) {
            nameFile = entry.getName();
            FileOutputStream fout = new FileOutputStream(pathToFile + "/new" + nameFile);

            for (int i = zip.read(); i != -1; i = zip.read()) {
                fout.write(i);
            }

            fout.flush();
            zip.closeEntry();
            fout.close();

            return pathToFile + "/new" + nameFile;
        }

        return null;
    }
}
