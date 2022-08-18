package com.example.demo;

import Model.*;
import org.springframework.web.bind.annotation.*;
/**
 * Webschnittstelle verwendet nur GET-Mappings
 * Ist in der Lage eine CSV einzulesen und eine Zeile zu einem passenden Wert auszugeben
 * Suchwert uns -spalte sind frei wählbar
 * <p>
 * TODO: 29.07.22 Get-Mappings durch POST oder PUT austauschen
 */
@RestController
@RequestMapping(value = "/api")
public class BetriebsstellenController {

    private CSVReader reader;  // Liest eine CSV-Datei ein und Filtert den Inhalt Zeilenweise

    public BetriebsstellenController(){
        this.reader = new CSVReader("src/main/java/Model/DBNetz-Betriebsstellenverzeichnis-Stand2021-10.csv"
                , ';');

    }

    /**
     * Sucht alle Zeilen in einer CSV, die ein bestimmtes Element enthalten.
     * Findet nichts falls in der falschen Spalte gesucht wird oder das gesuchte Element
     * bzw. die durchsuchte Spalte nicht existiert.
     * @param value Das Element nach dem Gesucht wird
     * @return Die gefundenen Zeilen im JSON-Format. [] wenn nichts gefunden wird.
     */
    @GetMapping("/{value}")
    public String getBetriebsstellenFilteredByValue(@PathVariable String value) {
        return (reader.readAndFilterByValue(value));
    }

    /**
     * Legt die Spalte fest in der nach einem Element gesucht wird.
     * Die Existenz der Spalte wird nicht geprueft!
     * @param value Der Name der es Spaltenkopfs
     * @return Bestätigungsnachricht, keine Pruefung ob Spalte existiert
     */
    @GetMapping("searchkey/{value}")
    public String updateSearchKey(@PathVariable String value) {
        reader.setSearch_key(value);
        return ("search_key set to: " + value + "\n");


    }
}
