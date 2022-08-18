package Model;

import com.opencsv.bean.CsvToBeanFilter;

/**
 * Filtert den CSV-Inhalt, eines Bestimmten Spaltentitels nach einem
 * bestimmten Element.
 */
public class CSVFilter implements CsvToBeanFilter {

    private String search_key;  //Spaltentitel
    private String search_value;  //Gesuchtes Element
    private String[] header;  //Alle vorhanden Spaltentitel

    /**
     * Konstruktor
     * @param search_key Spaltentitel unter dem das Element gesucht wird
     * @param search_value Gesuchtes Element
     * @param header Alle vorhanden Spaltentitel
     */
    public CSVFilter(String search_key, String search_value, String[] header) {
        this.search_key = search_key;
        this.search_value = search_value;
        this.header = header;
    }

    /**
     * Prueft ob ein Element in der zugehoerigen Spalte existiert.
     * @param strings CSV-Ziele die geprueft werden soll.
     * @return True falls Element gefunden, False falls Element oder Spalte nicht gefunden
     */
    @Override
    public boolean allowLine(String[] strings) {
        int index = getSearchKeyPosition();  //Suche Spaltenindex
        if (index == -1){ return false;}  //Falls die Spalte nicht gefunden wird
        return strings[index].equals(search_value);
    }

    /**
     * Findet die passende Spaltennummer anhand des Spaltennamens.
     * @return Die Spaltennummer (0-induziert). Falls die Spalte nicht gefunden wird -1
     */
    private int getSearchKeyPosition(){
        for (int i = 0; i < header.length; i++){
            if (header[i].equals(search_key)){
                return i;
            }
        }
        return -1;
    }
}
