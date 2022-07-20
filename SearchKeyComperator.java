package Model;

import java.util.Comparator;

/**
 * Vergleicht zwei CSV_Data-Objekte verwendet dazu den angegeben Spaltentitel
 * und vergleicht den korrespondierenden Inhalt miteinander.
 * Der Vergleich erfolgt lexikografisch.
 */
public class SearchKeyComperator implements Comparator<CSV_Data> {

    private String searchkey;

    public SearchKeyComperator(String searchkey){
        this.searchkey = searchkey;
    }

    @Override
    public int compare(CSV_Data d1, CSV_Data d2) {
        String value1 = d1.getDataByKey(searchkey);
        String value2 = d2.getDataByKey(searchkey);
        return value1.compareTo(value2);
    }
}
