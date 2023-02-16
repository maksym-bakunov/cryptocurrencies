package com.example.cryptocurrencies.controller;

import com.example.cryptocurrencies.config.AppConstans;
import com.example.cryptocurrencies.model.PairPrice;
import com.example.cryptocurrencies.serivice.CsvService;
import com.example.cryptocurrencies.serivice.PairPriceService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cryptocurrencies")
@RestController
public class CriptoController {
    private final PairPriceService pairPriceService;
    private final CsvService csvService;

    public CriptoController(PairPriceService pairPriceService, CsvService csvService) {
        this.pairPriceService = pairPriceService;
        this.csvService = csvService;
    }

    @GetMapping("/minprice")
    public ResponseEntity<Double> getMinPrice(@RequestParam String name) {
        return new ResponseEntity<>(pairPriceService.findMin(name), HttpStatus.OK);
    }

    @GetMapping("/maxprice")
    public ResponseEntity<Double> getMaxPrice(@RequestParam String name) {
        return new ResponseEntity<>(pairPriceService.findMax(name), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Double>> getDataWithPagination(
            @RequestParam String name,
            @RequestParam (defaultValue = "0") Integer page,
            @RequestParam (defaultValue = "10") Integer size) {
        return new ResponseEntity<>(pairPriceService
                .getDataWithPagination(name, page, size)
                .stream()
                .map(PairPrice::getPrice)
                .sorted().collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/csv")
    public ResponseEntity<List<String[]>> createCsv() {
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < AppConstans.CRYPTO_CURRENCY.length; i++) {

            String[] reccord = {AppConstans.CRYPTO_CURRENCY[i][0],
                    String.valueOf(pairPriceService.findMin(AppConstans.CRYPTO_CURRENCY[i][0])),
                    String.valueOf(pairPriceService.findMax(AppConstans.CRYPTO_CURRENCY[i][0]))};
            list.add(reccord);
        }
        try {
            csvService.write(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
