package com.passengerinfo.passengerinfo.service;

import com.passengerinfo.passengerinfo.resource.PassengerDto;

import java.util.List;

public interface PassengerService {
    List<PassengerDto> getAllPassenger(String authToken);
}
