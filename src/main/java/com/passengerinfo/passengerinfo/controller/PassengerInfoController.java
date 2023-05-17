package com.passengerinfo.passengerinfo.controller;

import com.passengerinfo.passengerinfo.resource.PassengerDto;
import com.passengerinfo.passengerinfo.service.PassengerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passenger-info")
public class PassengerInfoController {

    public final PassengerService passengerService;

    public PassengerInfoController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public List<PassengerDto> getAll(){
        return passengerService.getAllPassenger();
    }
}
