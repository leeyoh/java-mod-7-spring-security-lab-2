package com.example.demo.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the API to see if we get response
 */
class CoinCapServiceIntegrationTest {
    @Test
    void shouldReturnBitcoinPrice() {
        CoinCapService coinCapService = new CoinCapService();
        String bitcoinPrice = coinCapService.getBitcoinPrice();
        assertThat(bitcoinPrice).isNotNull();
//        String bitcoinPrice2 = coinCapService.getBitcoinPrice();
//        assertThat(bitcoinPrice2).isNotNull();
//        assertThat(bitcoinPrice).isNotEqualTo(bitcoinPrice2);
    }

    @Test
    void shouldReturnEtherPrices(){
        String currency = "ethereum";
        CoinCapService coinCapService = new CoinCapService();
        String cryptoPrice = coinCapService.getCurrencyPrice(currency);
        assertThat(cryptoPrice).isNotNull();
    }
}