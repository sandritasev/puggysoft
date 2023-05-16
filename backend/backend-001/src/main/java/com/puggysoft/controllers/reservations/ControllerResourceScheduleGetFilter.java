package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResResourceSchedule;
import com.puggysoft.dtos.reservations.DtoResResourceScheduleFilter;
import com.puggysoft.services.reservations.ServiceResourceScheduleGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerResourceScheduleGetFilter {

  @Autowired
  private ServiceResourceScheduleGetFilter serviceResourceScheduleGetFilter;

  @PostMapping(path = "/api/v1/reservations-resources-schedules/filter")
  public ResponseEntity<List<DtoResResourceSchedule>> getResourceScheduleFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoResResourceScheduleFilter dtoResourceScheduleFilter) {
    return serviceResourceScheduleGetFilter.filter(dtoResourceScheduleFilter, page, size);
  }
}
