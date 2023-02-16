package com.example.cryptocurrencies.serivice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

@Component
public class HttpClient {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public <T> T get(String url, Class<T> clazz) {
        HttpGet request = new HttpGet(url);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println(response.getStatusLine().toString());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.getEntity().getContent(), clazz);
        } catch (IOException e) {
            //throw new RuntimeException("Can't etch date from url" + url, e);
            throw new RuntimeException(e);
        }
    }
}
