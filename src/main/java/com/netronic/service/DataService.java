package com.netronic.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    public <T> T getData(String link, Class<? extends T> clazz) {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            T responseDto = objectMapper.readValue(inputStream, clazz);
            inputStream.close();
            connection.disconnect();
            return responseDto;
        } catch (Exception e) {
            throw new RuntimeException("Can't get data from this link " + link, e);
        }
    }
}
