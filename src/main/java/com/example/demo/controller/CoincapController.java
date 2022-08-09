package com.example.demo.controller;
import com.example.demo.service.CoinCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coincap")
public class CoincapController {
    @Autowired
    private CoinCapService coinCapService;
    public CoincapController(CoinCapService coinCapService){
        this.coinCapService = coinCapService;
    }
    @GetMapping
    public String getBitcoinPrice(){
        return coinCapService.getBitcoinPrice();
    }
    @GetMapping("/{currency}")
    public String getCurrencyPrice(@PathVariable String currency){return coinCapService.getCurrencyPrice(currency);
    }
}
