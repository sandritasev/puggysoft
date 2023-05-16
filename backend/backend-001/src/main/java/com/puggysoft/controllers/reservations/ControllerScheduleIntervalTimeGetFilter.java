package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResScheduleIntervalTime;
import com.puggysoft.dtos.reservations.DtoResScheduleIntervalTimeFilter;
import com.puggysoft.services.reservations.ServiceScheduleIntervalTimeGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerScheduleIntervalTimeGetFilter {

  @Autowired
  private ServiceScheduleIntervalTimeGetFilter serviceScheduleIntervalTimeGetFilter;

  @PostMapping(path = "/api/v1/reservations-schedules-intervals-times/filter")
  public ResponseEntity<List<DtoResScheduleIntervalTime>> getScheduleIntervalTimeFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoResScheduleIntervalTimeFilter dtoScheduleIntervalTimeFilter) {
    return serviceScheduleIntervalTimeGetFilter.filter(dtoScheduleIntervalTimeFilter, page, size);
  }
}