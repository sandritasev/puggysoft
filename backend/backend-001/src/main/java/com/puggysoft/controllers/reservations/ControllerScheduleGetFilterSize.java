package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResScheduleFilter;
import com.puggysoft.services.reservations.ServiceScheduleGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerScheduleGetFilterSize {

  @Autowired
  private ServiceScheduleGetFilterSize serviceScheduleGetFilterSize;

  @PostMapping(path = "/api/v1/reservations-schedules/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoResScheduleFilter dtoResScheduleFilter,
      @PathVariable Long pageSize) {
    return serviceScheduleGetFilterSize.getSize(dtoResScheduleFilter, pageSize);
  }
}