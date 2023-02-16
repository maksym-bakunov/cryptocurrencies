package com.example.cryptocurrencies.serivice;

import com.example.cryptocurrencies.dto.response.ApiPairPriceDto;
import com.example.cryptocurrencies.model.PairPrice;
import java.util.List;

public interface PairPriceService {
    void syncExternalPairPrices();

    void save(ApiPairPriceDto apiPairPrice);

    Double findMin(String curr);

    Double findMax(String curr);

    List<PairPrice> getDataWithPagination(String curr, int skip, int limit);
}
