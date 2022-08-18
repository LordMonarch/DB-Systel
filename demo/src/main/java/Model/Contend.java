package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Speichert den Inhalt einer CSV-Datei.
 * Liest dazu die Datei anhand eines Pfades und Spaltentrenners ein.
 * Durchsucht den Inhalt nach einem String in einer Passenden Spalte, gibt
 * bei einem Treffer die komplette Zeile zurück.
 * Der Spaltenname (searchkey) kann verändert werden.
 */
public class Contend {
    private String PATH;
    private String SEPARATOR;
    private String search_key;
    private ArrayList<CSV_Data> dataList;

    /**
     * Belegt die Variablen. Definiert den searchkey
     * mit "RL100-Code"
     * @param PATH Der absolute Dateipfad
     * @param SEPARATOR Der Zeilentrenner
     */
    public Contend(String PATH, String SEPARATOR){
        this.PATH = PATH;
        this.SEPARATOR = SEPARATOR;
        this.search_key = "RL100-Code";
    }

    /**
     * Liest die CSV-Datei ein, die in den Klassenvariablen
     * hinterlegt ist.
     */
    public void read(){
        CSV_Reader reader = new CSV_Reader(PATH,SEPARATOR);
        dataList = (ArrayList<CSV_Data>) reader.read_CSV();
    }

    /**
     * Setzt den den Spaltentitel der durchsucht wird.
     * @param sk Der Spaltentitel
     */
    public void setSearch_key(String sk){
        this.search_key = sk;
    }

    /**
     * Filtert die CSV-Daten anhand des übergebenen Inhalts. Verwendet die in der
     * Klassenvariable hinterlegten Spalte.
     * @param value Der zu suchende Inhalt
     * @return Die Komplette Zeile des Inhalts der zuerst gefunden wird als JSON-String
     */
    public String getFilterdDataByValue(String value){
        CSV_Data dummy = new CSV_Data(search_key, value);  // Dummy mit dem Suchbegriff
        Collections.sort(this.dataList, new SearchKeyComperator(search_key));  // Notwendig für Binärsuche
        int i = Collections.binarySearch(dataList, dummy, new SearchKeyComperator(search_key)); // Binäresuche
        if(i < 0){
            return "Nichts gefunden!";
        }else{
            return dataList.get(i).toJSON();
        }

    }
}
