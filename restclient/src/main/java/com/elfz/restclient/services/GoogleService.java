package com.elfz.restclient.services;

import com.elfz.restclient.entities.Site;
import com.elfz.restclient.json.GoogleResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GoogleService {

    private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String KEY = "AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";

    private RestTemplate restTemplate;

    GoogleService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Site getSite(String... address){
        String joinedAddress = String.join(",", address);
        String url = String.format("%s?address=%s&key=%s", BASE, joinedAddress, KEY);
        String encode = URLEncoder.encode(url, StandardCharsets.UTF_8);
        GoogleResponse response = restTemplate.getForObject(url, GoogleResponse.class);
        return new Site(response.getLat(), response.getLng(), response.getAddress());
    }

}
