package com.puggysoft.controllers.reservations;

import com.puggysoft.services.reservations.ServiceScheduleIntervalTimeDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerScheduleIntervalTimeDeleteById {

  @Autowired
  private ServiceScheduleIntervalTimeDeleteById serviceScheduleIntervalTimeDeleteById;

  @DeleteMapping(path = "/api/v1/reservations-schedules-intervals-times/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceScheduleIntervalTimeDeleteById.deleteById(id);
  }
}
