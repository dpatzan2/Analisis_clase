import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV_read {
    private String filePath;

    public CSV_Read(String filePath) {
        this.filePath = filePath;
    }

    public List<String[]> readCSV() {
        List<String[]> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static void main(String[] args) {
        String filePath = "ruta_del_archivo.csv"; // Reemplaza con la ruta de tu archivo CSV
        CSV_Read csvReader = new CSV_Read(filePath);
        List<String[]> csvData = csvReader.readCSV();

        // Mostrar los datos leídos del CSV
        for (String[] row : csvData) {
            for (String value : row) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }
    }
