package com.passengerinfo.passengerinfo.controller;

import com.passengerinfo.passengerinfo.resource.PassengerDto;
import com.passengerinfo.passengerinfo.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger-info")
@CrossOrigin(origins = "*")
public class PassengerInfoController {

    public final PassengerService passengerService;

    public PassengerInfoController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public List<PassengerDto> getAll(@RequestHeader(value = "Authorization") String authHeader){
        return passengerService.getAllPassenger(authHeader);
    }
}
