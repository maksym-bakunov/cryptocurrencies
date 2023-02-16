package com.example.cryptocurrencies.repository;

import com.example.cryptocurrencies.model.PairPrice;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PairPriceRepository extends MongoRepository<PairPrice, String> {
    @Aggregation(pipeline = { "{$match: {curr1: ?0}}",
            "{$group: { _id: '$curr1', max_value: {$max: $price }}}" })
    Optional<Double> max(String curr);

    @Aggregation(pipeline = { "{$match: {curr1: ?0}}",
            "{$group: { _id: '$curr1', min_value: {$min: $price }}}" })
    Optional<Double> min(String curr);

    @Aggregation(pipeline = { "{$match: {curr1: ?0}}", "{$skip: ?1}", "{$limit: ?2}" })
    List<PairPrice> getPagination(String curr, int skip, int limit);
}
