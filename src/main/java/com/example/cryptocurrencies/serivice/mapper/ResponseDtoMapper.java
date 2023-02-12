package com.example.cryptocurrencies.serivice.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
