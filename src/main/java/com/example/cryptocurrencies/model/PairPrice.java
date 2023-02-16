package com.example.cryptocurrencies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pair_price")
public class PairPrice {
    @Id
    private String id;
    private String curr1;
    private String curr2;
    private Double price;
}
