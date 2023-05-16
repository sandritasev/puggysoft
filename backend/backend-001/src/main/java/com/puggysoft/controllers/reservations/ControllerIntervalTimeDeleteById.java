package com.puggysoft.controllers.reservations;

import com.puggysoft.services.reservations.ServiceIntervalTimeDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerIntervalTimeDeleteById {

  @Autowired
  private ServiceIntervalTimeDeleteById serviceIntervalTimeDeleteById;

  @DeleteMapping(path = "/api/v1/reservations-intervals-times/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceIntervalTimeDeleteById.deleteById(id);
  }
}
