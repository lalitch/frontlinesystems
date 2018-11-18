package com.plessentials.frontlinesystems.utils;

import com.plessentials.frontlinesystems.exceptions.ErrorResponseException;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestClient<T> {
    private HttpClient httpClient;
    private Class<? extends T> tClass;

    public RestClient(Class<? extends T> tClass) {
        this.tClass = tClass;
        this.httpClient = HttpClient.newHttpClient();
    }

    public T get(URI requestUri) {
        HttpRequest request = HttpRequest
                .newBuilder(requestUri)
                .GET()
                .build();

        try {
            HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() > 299)
            {
                throw new ErrorResponseException(HttpStatus.valueOf(response.statusCode()), response.body());
            }

            return (T)JsonUtils.parseToObject(response.body(), this.tClass);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}

