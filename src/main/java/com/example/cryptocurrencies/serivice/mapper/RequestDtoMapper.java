package com.example.cryptocurrencies.serivice.mapper;

public interface RequestDtoMapper <D, T>{
    D mapToModel(T t);
}
