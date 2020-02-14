package com.elfz.restclient.services;

import com.elfz.restclient.entities.Site;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoogleServiceTest {

    @Autowired
    private GoogleService googleService;

    private Logger logger = LoggerFactory.getLogger(GoogleServiceTest.class);

    @Test
    void getLatLngForGoogleHeadQuarters() {

        double expectedLat = 37.42;
        double expectedLng = -122.08;
        double delta = 0.01;

        Site site = googleService.getSite("1600 Amphitheatre Parkway", "Mountain View", "CA");
        logger.info(site.toString());

        double actualLat = site.getLatitude();
        double actualLng = site.getLongitude();

        Assertions.assertEquals(expectedLat, actualLat, delta);
        Assertions.assertEquals(expectedLng, actualLng, delta);

    }
}