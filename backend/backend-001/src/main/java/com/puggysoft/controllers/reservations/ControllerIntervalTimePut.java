package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResIntervalTime;
import com.puggysoft.services.reservations.ServiceIntervalTimeEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerIntervalTimePut {

  @Autowired
  private ServiceIntervalTimeEditById serviceIntervalTimeEditById;

  @PutMapping(path = "/api/v1/reservations-intervals-times/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoResIntervalTime dtoResIntervalTime) {
    return serviceIntervalTimeEditById.editById(id, dtoResIntervalTime);
  }
}