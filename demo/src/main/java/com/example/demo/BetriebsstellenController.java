package com.example.demo;


import Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BetriebsstellenController {

    private Contend betriebsstellen;

    public BetriebsstellenController(){

        this.betriebsstellen = new Contend("C:\\Users\\Rainer" +
                "\\IdeaProjects\\demo\\src\\main\\java\\Model" +
                "\\DBNetz-Betriebsstellenverzeichnis-Stand2021-10.csv",
                ";");

        this.betriebsstellen.read();
    }

    // Single item
    @GetMapping("/{str}")
    String getOneBetriebsstellen(@PathVariable String str) {
        return betriebsstellen.getFilterdDataByValue(str);
    }

    @GetMapping("searchkey/{str}")
    void replaceSearchKey(@PathVariable String str) {
        System.out.println(str);

        betriebsstellen.setSearch_key(str);
    }
}
