package com.example.cryptocurrencies.serivice.impl;

import com.example.cryptocurrencies.serivice.CsvService;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CsvServiceImpl implements CsvService {
    @Override
    public void write(List<String[]> data) throws IOException {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("report.csv"))) {
            csvWriter.writeAll(data);
        }
    }
}
