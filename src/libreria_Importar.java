import com.opencsv.CSVReader;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class libreria_Importar {

    public static void main(String[] args) {
        String fileUrl = "https://sourceforge.net/projects/opencsv/files/opencsv/5.5/opencsv-5.5.jar";
        String filePath = "opencsv-5.5.jar";

        // Descargar el archivo opencsv desde SourceForge
        try {
            downloadFile(fileUrl, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Llamarlo para leer el archivo CSV
        File csvFile = new File("ruta/de/tu/archivo.csv"); // Cambia "ruta/de/tu/archivo.csv" a la ubicación real de tu
                                                           // archivo CSV
        readCSVFile(csvFile);
    }

    public static void downloadFile(String fileUrl, String filePath) throws IOException {
        URL url = new URL(fileUrl);
        try (InputStream in = url.openStream();
                ReadableByteChannel rbc = Channels.newChannel(in);
                FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

    public static void readCSVFile(File csvFile) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Procesa cada línea del archivo CSV aquí
                for (String cell : nextLine) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
