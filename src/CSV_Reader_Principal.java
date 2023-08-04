import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSV_Reader_Principal {
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
        File csvFile = new File("ruta/de/tu/archivo.csv"); // Cambia "ruta/de/tu/archivo.csv" a la ubicación real de tu archivo CSV
        String[] palabras = readCSVFile(csvFile);
        for (String palabra : palabras) {
            System.out.print(palabra + "\t");
        }
    }

    public static void downloadFile(String fileUrl, String filePath) throws IOException {
        URL url = new URL(fileUrl);
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

    public static String[] readCSVFile(File csvFile) {
        CSVReader reader = null; // Declare the reader variable outside the try block
        try {
            reader = new CSVReader(new FileReader(csvFile)); // Initialize the reader inside the try block

            // Count the number of lines in the CSV file to initialize the array size
            int numLines = 0;
            while (reader.readNext() != null) {
                numLines++;
            }

            String[] palabras = new String[numLines];
            reader.close();

            // Re-open the CSVReader to read data again
            reader = new CSVReader(new FileReader(csvFile));

            String[] nextLine;
            int i = 0;
            while ((nextLine = reader.readNext()) != null) {
                // Assuming the CSV file has only one cell per line
                palabras[i++] = nextLine[0];
            }
            return palabras;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } finally {
            // Make sure to close the reader in the finally block to release resources
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}