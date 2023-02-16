package com.example.cryptocurrencies.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiPairPriceDto {
    private String curr1;
    private String curr2;
    private Double lprice;
}
