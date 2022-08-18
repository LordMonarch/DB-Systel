package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Liest eine CSV-Datei ein, erwartet dabei den Pfad als String und den
 * Spaltentrenner als String im Konstruktor.
 */
public class CSV_Reader {

    private String path;
    private String separator;

    /**
     * Übernimmt den Pfad und den Zeilenseparator.
     * @param path Der absolute Pfad zur Zieldatei
     * @param separator Der Spaltentrenner
     */
    public CSV_Reader(String path, String separator){
        this.path = path;
        this.separator = separator;
    }

    /**
     * Liest die Datei zeilenweise ein und wandelt den Inhalt
     * zeilenweise in ein CSV_Data-Objekt um.
     * @return
     */
    public List<CSV_Data> read_CSV(){
        ArrayList<CSV_Data> dataList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String row = "";
            while((row = br.readLine()) != null){
                dataList.add(new CSV_Data(row.split(separator)));
            }
            return dataList;

        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
            return null;
        }
    }
}
