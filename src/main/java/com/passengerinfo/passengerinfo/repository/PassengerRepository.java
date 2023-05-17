package com.passengerinfo.passengerinfo.repository;

import com.passengerinfo.passengerinfo.model.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerInfo, Long> {
}
