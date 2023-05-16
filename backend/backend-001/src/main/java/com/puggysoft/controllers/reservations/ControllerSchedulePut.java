package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResSchedule;
import com.puggysoft.services.reservations.ServiceScheduleEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerSchedulePut {

  @Autowired
  private ServiceScheduleEditById serviceScheduleEditById;

  @PutMapping(path = "/api/v1/reservations-schedules/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoResSchedule dtoResSchedule) {
    return serviceScheduleEditById.editById(id, dtoResSchedule);
  }
}
