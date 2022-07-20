package Model;

import java.util.HashMap;

/**
 * Bildet eine Zeile einer CSV-Datei ab.
 * Speichert die Spaltentitel statisch und den Inhalt in einer
 * Hashmap<Zeilentitel, Passender Zeileninhalt>
 */
public class CSV_Data{
    private static String[] rowhead;
    private HashMap<String, String> rowdata;

    /**
     * Konstruktor für einen Dummy der nur einen definierten Zeilentitel
     * mit Inhalt enthält.
     * @param key Der Zeilentitel, passend zum searchkey
     * @param data Der passende Inhalt, der gesucht werden soll.
     */
    public CSV_Data(String key, String data){
        rowdata = new HashMap<String, String>();
        rowdata.put(key, data);
    }

    /**
     * Erzeugt Zeilentitel falls noch nicht vorhanden. Fügt in jedem fall den
     * gelesenen Inhalt hinzu.
     * @param data Speichert den Zeileninhalt in einer Hashmap<Titel, Inhalt>
     */
    public CSV_Data(String[] data){
        if( rowhead == null){
            rowhead = data;
        }

        rowdata = new HashMap<String, String>();
        for(int i = 0; i < data.length; i++){
            rowdata.put(rowhead[i], data[i]);
        }
    }

    /**
     * Gibt daten zu einem Zeilentitel zurück
     * @param key Zeilentitel der Spalte mit der Information
     * @return  Die Information der Zeilenspalte
     */
    public String getDataByKey(String key){
        return rowdata.get(key);
    }

    /**
     * Wandelt die Informationen in einen JSON-Format um.
     * @return Die Daten im JSON-Format als String
     */
    public String toJSON(){
        StringBuilder sb = new StringBuilder();  // Stringbuilder wegen Schleifenkonkartination
        sb.append("{");
        for(String s: rowdata.keySet()){
            sb.append(s);
            sb.append(": ");
            sb.append(rowdata.get(s));
            if(!s.equals(rowhead[rowhead.length - 1])) {  //Nur wenn es NICHT das letzte
                sb.append("; ");                          // Element ist ein ; hinzufügen
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
