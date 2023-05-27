package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResResourceScheduleFilter;
import com.puggysoft.services.reservations.ServiceResourceScheduleGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerResourceScheduleGetFilterSize {

  @Autowired
  private ServiceResourceScheduleGetFilterSize serviceResourceScheduleGetFilterSize;

  @PostMapping(path = "/api/v1/reservations-resources-schedules/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoResResourceScheduleFilter dtoResResourceScheduleFilter,
      @PathVariable Long pageSize) {
    return serviceResourceScheduleGetFilterSize.getSize(dtoResResourceScheduleFilter,
        pageSize);
  }
}