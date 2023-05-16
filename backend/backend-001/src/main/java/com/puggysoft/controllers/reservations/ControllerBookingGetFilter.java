package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResBooking;
import com.puggysoft.dtos.reservations.DtoResBookingFilter;
import com.puggysoft.services.reservations.ServiceBookingGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBookingGetFilter {

  @Autowired
  private ServiceBookingGetFilter serviceBookingGetFilter;

  @PostMapping(path = "/api/v1/reservations-bookings/filter")
  public ResponseEntity<List<DtoResBooking>> getBookingFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoResBookingFilter dtoBookingFilter) {
    return serviceBookingGetFilter.filter(dtoBookingFilter, page, size);
  }
}
