package com.elfz.restclient.services;

import com.elfz.restclient.json.JokeResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

    private static final String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

    private RestTemplate restTemplate;

    public JokeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getJoke(String first, String last){

        String url = String.format("%s&firstName=%s&lastName=%s", BASE, first, last);
        JokeResponse response = this.restTemplate.getForObject(url, JokeResponse.class);

        String joke = "";
        if (response != null)
            if (response.getValue() != null)
                joke = response.getValue().getJoke();

        return joke;
    }

}
