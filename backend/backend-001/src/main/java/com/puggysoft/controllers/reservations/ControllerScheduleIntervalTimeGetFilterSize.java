package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResScheduleIntervalTimeFilter;
import com.puggysoft.services.reservations.ServiceScheduleIntervalTimeGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerScheduleIntervalTimeGetFilterSize {

  @Autowired
  private ServiceScheduleIntervalTimeGetFilterSize serviceScheduleIntervalTimeGetFilterSize;

  @PostMapping(path = "/api/v1/reservations-schedules-intervals-times/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoResScheduleIntervalTimeFilter dtoResScheduleIntervalTimeFilter,
      @PathVariable Long pageSize) {
    return serviceScheduleIntervalTimeGetFilterSize.getSize(dtoResScheduleIntervalTimeFilter,
        pageSize);
  }
}
