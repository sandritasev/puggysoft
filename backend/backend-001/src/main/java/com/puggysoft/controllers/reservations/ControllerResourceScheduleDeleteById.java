package com.puggysoft.controllers.reservations;

import com.puggysoft.services.reservations.ServiceResourceScheduleDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerResourceScheduleDeleteById {

  @Autowired
  private ServiceResourceScheduleDeleteById serviceResourceScheduleDeleteById;

  @DeleteMapping(path = "/api/v1/reservations-resources-schedules/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceResourceScheduleDeleteById.deleteById(id);
  }
}