package com.mildw.minsu;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

public class RestTemplateTest {
    public static void main(String[] args) {

        String URL = "https://apis.naver.com/vibeWeb/musicapiweb/v1/artist/";
        for(int idx=1; idx<4; idx++){
            String URI = URL+idx;
            System.out.println(URI);

            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
            ResponseEntity<String> response = restTemplate.getForEntity(URI,String.class);
            System.out.println(response.getBody());

        }

    }
}
