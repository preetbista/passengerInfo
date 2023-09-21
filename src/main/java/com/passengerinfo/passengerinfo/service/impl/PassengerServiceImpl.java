package com.passengerinfo.passengerinfo.service.impl;

import com.passengerinfo.passengerinfo.resource.PassengerDto;
import com.passengerinfo.passengerinfo.service.PassengerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PassengerServiceImpl implements PassengerService {

    private final RestTemplate restTemplate;

    @Override
    public List<PassengerDto> getAllPassenger(String authToken){
        log.info("book-ticket/ticket");
        String endpointUrl = "http://flight-service/book-ticket/ticket";

        HttpHeaders headers = new HttpHeaders();
        if (!authToken.contains("Bearer")) {
            authToken += "Bearer";
        }
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", authToken);
        HttpEntity<String> authEntity = new HttpEntity<>(headers);

        ResponseEntity<PassengerDto[]> responseEntity = restTemplate.exchange(
                endpointUrl, HttpMethod.GET , authEntity, PassengerDto[].class);

        PassengerDto[] passengerDtos = responseEntity.getBody();
        assert passengerDtos != null;

        String[] usernameList = restTemplate.exchange(
                "http://flight-service/users/user-rest", HttpMethod.GET, authEntity, String[].class).getBody();

        String[] seatNameList = restTemplate.exchange(
                "http://flight-service/cabins/cabin-rest", HttpMethod.GET, authEntity, String[].class).getBody();

        for (int i = 0; i < passengerDtos.length; i++) {
            assert seatNameList != null;
            passengerDtos[i].setSeatName(seatNameList[i]);
            assert usernameList != null;
            passengerDtos[i].setUserName(usernameList[i]);
        }
        log.info("After traversing");

        return Arrays.asList(passengerDtos);
    }
}
