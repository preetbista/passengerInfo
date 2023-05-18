package com.passengerinfo.passengerinfo.service.impl;

import com.passengerinfo.passengerinfo.resource.PassengerDto;
import com.passengerinfo.passengerinfo.service.PassengerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PassengerServiceImpl implements PassengerService {

    @Override
    public List<PassengerDto> getAllPassenger(){
        log.info("book-ticket/ticket");
        RestTemplate restTemplate = new RestTemplate();
        String endpointUrl = "http://localhost:8085/book-ticket/ticket";

        ResponseEntity<PassengerDto[]> responseEntity = restTemplate.getForEntity(
                endpointUrl, PassengerDto[].class);

        PassengerDto[] passengerDtos = responseEntity.getBody();
        assert passengerDtos != null;

        String[] usernameList = restTemplate.getForEntity(
                "http://localhost:8085/users/user-rest", String[].class).getBody();

        String[] seatNameList = restTemplate.getForEntity(
                "http://localhost:8085/cabins/cabin-rest", String[].class).getBody();

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
