package Model;


import com.opencsv.bean.CsvBindByName;

/**
 * Modellklasse zum Einlesen der Betriebsstaetten-CSV
 * Alle Methoden außer getHeader() sind automatisch generiert
 */
public class Betriebsstaetten {
    @CsvBindByName(column = "PLC")
    private String plc;
    @CsvBindByName(column = "RL100-Code")
    private String rl100_Code;
    @CsvBindByName(column = "RL100-Langname")
    private String rl100_langname;
    @CsvBindByName(column = "RL100-Kurzname")
    private String rl100_kurzname;
    @CsvBindByName(column = "Typ Kurz")
    private String typ_kurz;
    @CsvBindByName(column = "Typ Lang")
    private String typ_lang;
    @CsvBindByName(column = "Betriebszustand")
    private String betriebszustand;
    @CsvBindByName(column = "Datum ab")
    private String datum_ab;
    @CsvBindByName(column = "Datum bis")
    private String datum_bis;
    @CsvBindByName(column = "Niederlassung")
    private String niederlassung;
    @CsvBindByName(column = "Regionalbereich")
    private String regionalbereich;
    @CsvBindByName(column = "Letzte Änderung")
    private String letzte_aenderung;

    private final String HEADER = "PLC" +
            ";RL100-Code" +
            ";RL100-Langname" +
            ";RL100-Kurzname" +
            ";Typ Kurz" +
            ";Typ Lang" +
            ";Betriebszustand" +
            ";Datum ab" +
            ";Datum bis" +
            ";Niederlassung" +
            ";Regionalbereich" +
            ";Letzte Änderung";

    /**
     * Ermittelt den Spaltentitel der CSV-Datei aus der ersten Zeile der Datei.
     * @return Spaltentitel, ein Titel je Element
     */
    public String[] getHeader(){
        return (HEADER.split(";"));
    }

    @Override
    public String toString() {
        return "Betriebsstaetten{" +
                "plc='" + plc + '\'' +
                ", rl100_Code='" + rl100_Code + '\'' +
                ", rl100_langname='" + rl100_langname + '\'' +
                ", rl100_kurzname='" + rl100_kurzname + '\'' +
                ", typ_kurz='" + typ_kurz + '\'' +
                ", typ_lang='" + typ_lang + '\'' +
                ", betriebszustand='" + betriebszustand + '\'' +
                ", datum_ab='" + datum_ab + '\'' +
                ", datum_bis='" + datum_bis + '\'' +
                ", niederlassung='" + niederlassung + '\'' +
                ", regionalbereich='" + regionalbereich + '\'' +
                ", letzte_aenderung='" + letzte_aenderung + '\'' +
                '}';
    }

    public String getPlc() {
        return plc;
    }

    public void setPlc(String plc) {
        this.plc = plc;
    }

    public String getRl100_Code() {
        return rl100_Code;
    }

    public void setRl100_Code(String rl100_Code) {
        this.rl100_Code = rl100_Code;
    }

    public String getRl100_langname() {
        return rl100_langname;
    }

    public void setRl100_langname(String rl100_langname) {
        this.rl100_langname = rl100_langname;
    }

    public String getRl100_kurzname() {
        return rl100_kurzname;
    }

    public void setRl100_kurzname(String rl100_kurzname) {
        this.rl100_kurzname = rl100_kurzname;
    }

    public String getTyp_kurz() {
        return typ_kurz;
    }

    public void setTyp_kurz(String typ_kurz) {
        this.typ_kurz = typ_kurz;
    }

    public String getTyp_lang() {
        return typ_lang;
    }

    public void setTyp_lang(String typ_lang) {
        this.typ_lang = typ_lang;
    }

    public String getBetriebszustand() {
        return betriebszustand;
    }

    public void setBetriebszustand(String betriebszustand) {
        this.betriebszustand = betriebszustand;
    }

    public String getDatum_ab() {
        return datum_ab;
    }

    public void setDatum_ab(String datum_ab) {
        this.datum_ab = datum_ab;
    }

    public String getDatum_bis() {
        return datum_bis;
    }

    public void setDatum_bis(String datum_bis) {
        this.datum_bis = datum_bis;
    }

    public String getNiederlassung() {
        return niederlassung;
    }

    public void setNiederlassung(String niederlassung) {
        this.niederlassung = niederlassung;
    }

    public String getRegionalbereich() {
        return regionalbereich;
    }

    public void setRegionalbereich(String regionalbereich) {
        this.regionalbereich = regionalbereich;
    }

    public String getLetzte_aenderung() {
        return letzte_aenderung;
    }

    public void setLetzte_aenderung(String letzte_aenderung) {
        this.letzte_aenderung = letzte_aenderung;
    }
}
