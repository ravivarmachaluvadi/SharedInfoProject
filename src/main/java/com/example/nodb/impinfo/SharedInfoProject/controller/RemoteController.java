package com.example.nodb.impinfo.SharedInfoProject.controller;

import com.example.nodb.impinfo.SharedInfoProject.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/remote")
@Slf4j
public class RemoteController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/response")
    public ResponseEntity getPayload() {

       ResponseEntity responseEntity= new ResponseEntity<String>("Custom Response", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

        // URI (URL) parameters
        Map<String, String> uriParams = new HashMap<>();

        // Query parameters
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();

        String unresolvedUrl = "https://jsonplaceholder.typicode.com/users";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(unresolvedUrl).queryParams(queryParams);
        String resolvedUrl = builder.buildAndExpand(uriParams).toUriString();

        //Setting Up Headers
        HttpHeaders httpHeaders = new HttpHeaders();
        List<MediaType> mediaTypeList = new ArrayList<>();
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(mediaTypeList);

        StringBuffer responsePayLoad = null;

        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);

        try {
            responseEntity= restTemplate.exchange(resolvedUrl, HttpMethod.GET, requestEntity,String.class);
        } catch (Exception e) {
            log.error("Exception while invoking receive return endpoint for " +e.getMessage());
        }
        return responseEntity;
    }
}
