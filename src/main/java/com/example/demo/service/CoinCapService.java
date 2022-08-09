package com.example.demo.service;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.List;

@Service
public class CoinCapService {
    private final String apiURLbase = "https://api.coincap.io/v2/assets";
    public String getBitcoinPrice(){
        String path = apiURLbase + "/bitcoin";
        RestTemplate restTemplate = new RestTemplate();
        Crypto res = restTemplate.getForObject(path, Crypto.class);
        return res.data.priceUsd;
    }
    public String getCurrencyPrice(String currency){
        String path = apiURLbase + "/" + currency;
        RestTemplate restTemplate = new RestTemplate();
        Crypto res = restTemplate.getForObject(path, Crypto.class);
        return res.data.priceUsd;
    }

}
class Crypto{
    public String timestamp;
    public Data data;
}
@Getter
@Setter
class Data {
    public String priceUsd;
    public String marketCapUsd;
    public String name;
}