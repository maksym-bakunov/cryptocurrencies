package com.example.cryptocurrencies.serivice.impl;

import com.example.cryptocurrencies.config.AppConstans;
import com.example.cryptocurrencies.dto.response.ApiPairPriceDto;
import com.example.cryptocurrencies.exception.AppEntityNotFoundException;
import com.example.cryptocurrencies.model.PairPrice;
import com.example.cryptocurrencies.repository.PairPriceRepository;
import com.example.cryptocurrencies.serivice.HttpClient;
import com.example.cryptocurrencies.serivice.PairPriceService;
import com.example.cryptocurrencies.serivice.mapper.PairPriceMapper;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PairPriceServiceImpl implements PairPriceService {
    private static final String API_URL = "https://cex.io/api/last_price/";
    private final PairPriceRepository pairPriceRepository;
    private final PairPriceMapper pairPriceMapper;
    private final HttpClient httpClient;

    public PairPriceServiceImpl(PairPriceRepository pairPriceRepository,
                                PairPriceMapper pairPriceMapper, HttpClient httpClient) {
        this.pairPriceRepository = pairPriceRepository;
        this.pairPriceMapper = pairPriceMapper;
        this.httpClient = httpClient;
    }

    @Scheduled(cron = "*/10 * * * * ?")
    @Override
    public void syncExternalPairPrices() {

        ApiPairPriceDto apiPairPriceDto;
        for (int i = 0; i < AppConstans.CRYPTO_CURRENCY.length; i++) {
            apiPairPriceDto = httpClient
                    .get(API_URL
                            + AppConstans.CRYPTO_CURRENCY[i][0] + "/"
                            + AppConstans.CRYPTO_CURRENCY[i][1], ApiPairPriceDto.class);
            save(apiPairPriceDto);
        }
    }

    @Override
    public void save(ApiPairPriceDto apiPairPrice) {
        pairPriceRepository.save(pairPriceMapper.mapToModel(apiPairPrice));
    }

    @Override
    public Double findMin(String curr) {
        return pairPriceRepository.min(curr)
                .orElseThrow(() -> new AppEntityNotFoundException(curr));
    }

    @Override
    public Double findMax(String curr) {
        return pairPriceRepository.max(curr)
                .orElseThrow(() -> new AppEntityNotFoundException(curr));
    }

    @Override
    public List<PairPrice> getDataWithPagination(String curr, int skip, int limit) {
        return pairPriceRepository.getPagination(curr, skip, limit);
    }
}
