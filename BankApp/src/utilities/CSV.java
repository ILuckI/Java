package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {

    // metoda wczytuje informacje z pliku i zwraca je w postaci listy
    public static List<String[]> read(String file) throws IOException {

        // tworzymy liste Linked
        List<String[]> data = new LinkedList<String[]>();
        String dataRow;

        // tworzymy buffor do pliku
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            // wczytujemy plik i dzielimy plik
            while ((dataRow = br.readLine()) != null) {
                String[] dataRec = dataRow.split(",");
                data.add(dataRec);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
