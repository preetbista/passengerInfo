package com.passengerinfo.passengerinfo.resource;

import com.passengerinfo.passengerinfo.model.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto implements Serializable {
    private String userName;

    private LocalDateTime travelDate;

    private String departureAirport;

    private String arrivalAirport;

    private String departureTime;

    private String arrivalTime;

    private String seatName;

    public static PassengerDto of(PassengerInfo passengerInfo){
        return new PassengerDto(passengerInfo.getUserName(),
                passengerInfo.getTravelDate(),
                passengerInfo.getDepartureAirport(),
                passengerInfo.getArrivalAirport(),
                passengerInfo.getArrivalTime(),
                passengerInfo.getDepartureTime(),
                passengerInfo.getSeatName()
                );
    }
}
