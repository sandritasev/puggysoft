package com.puggysoft.controllers.reservations;

import com.puggysoft.services.reservations.ServiceBookingDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBookingDeleteById {

  @Autowired
  private ServiceBookingDeleteById serviceBookingDeleteById;

  @DeleteMapping(path = "/api/v1/reservations-bookings/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceBookingDeleteById.deleteById(id);
  }
}