package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.CsvToBeanFilter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Liest eine CSV-Datei ein. Filtert dabei den Inhalt und gibt die
 * gefunden kompletten Zeilen im JSON-Format zurueck
 */
public class CSVReader {

    private final String PATH;  //Pfad zur CSV-Datei
    private final char SEPARATOR;  //Spaltentrenner der CSV-Datei
    private String search_key;  //Titel der Spalte die durchsucht werden soll

    /**
     * Konstruktor initialsiert Spaltentitel mit "RL100-Code"
     * @param PATH Pfad zur CSV-Datei
     * @param SEPARATOR Spaltentrenner der CSV-Datei
     */
    public CSVReader(String PATH, char SEPARATOR) {
        this.PATH = PATH;
        this.SEPARATOR = SEPARATOR;
        this.search_key = "RL100-Code";
    }

    /**
     * Liest die CSV mit OPENCSV ein. Filtert das Ergebnis nach einem Element mit einer Filterklasse.
     * Wandelt das Ergebnis in eine JSON mittels gson
     * @param value Das Element nach dem Gefiltert werden soll
     * @return Die gefundenen Zeilen aus der CSV-Datei oder null bei einem Fehler
     */
    public String readAndFilterByValue(String value){
        try{
            File file = new File(PATH);
            CsvToBeanFilter filter = new CSVFilter(search_key, value, new Betriebsstaetten().getHeader());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            List<Betriebsstaetten> beans = new CsvToBeanBuilder(new FileReader(file))
                    .withType(Betriebsstaetten.class)
                    .withSeparator(SEPARATOR)
                    .withFilter(filter)
                    .build().parse();

            return gson.toJson(beans);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Setzt den Spaltentitel in dem gesucht werden soll
     * @param search_key Der Spaltentitel
     */
    public void setSearch_key(String search_key) {
        this.search_key = search_key;
    }
}
