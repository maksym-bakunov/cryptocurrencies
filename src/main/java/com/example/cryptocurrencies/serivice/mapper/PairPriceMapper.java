package com.example.cryptocurrencies.serivice.mapper;

import com.example.cryptocurrencies.dto.response.ApiPairPriceDto;
import com.example.cryptocurrencies.model.PairPrice;
import org.springframework.stereotype.Component;

@Component
public class PairPriceMapper implements RequestDtoMapper<PairPrice, ApiPairPriceDto> {

    @Override
    public PairPrice mapToModel(ApiPairPriceDto apiPairPriceDto) {
        PairPrice pairPrice = new PairPrice();
        pairPrice.setCurr1(apiPairPriceDto.getCurr1());
        pairPrice.setCurr2(apiPairPriceDto.getCurr2());
        pairPrice.setPrice(apiPairPriceDto.getPrice());
        return pairPrice;
    }
}
