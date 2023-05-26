package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResBookingFilter;
import com.puggysoft.services.reservations.ServiceBookingGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerBookingGetFilterSize {

  @Autowired
  private ServiceBookingGetFilterSize serviceBookingGetFilterSize;

  @PostMapping(path = "/api/v1/booking/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoResBookingFilter dtoResBookingFilter,
      @PathVariable Long pageSize) {
    return serviceBookingGetFilterSize.getSize(dtoResBookingFilter, pageSize);
  }
}