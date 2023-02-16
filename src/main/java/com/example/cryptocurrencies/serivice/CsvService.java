package com.example.cryptocurrencies.serivice;

import java.io.IOException;
import java.util.List;

public interface CsvService {
    void write(List<String[]> data) throws IOException;
}
