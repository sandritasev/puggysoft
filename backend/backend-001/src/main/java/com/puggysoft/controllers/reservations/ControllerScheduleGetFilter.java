package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResSchedule;
import com.puggysoft.dtos.reservations.DtoResScheduleFilter;
import com.puggysoft.services.reservations.ServiceScheduleGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerScheduleGetFilter {

  @Autowired
  private ServiceScheduleGetFilter serviceScheduleGetFilter;

  @PostMapping(path = "/api/v1/reservations-schedule/filter")
  public ResponseEntity<List<DtoResSchedule>> getScheduleFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoResScheduleFilter dtoScheduleFilter) {
    return serviceScheduleGetFilter.filter(dtoScheduleFilter, page, size);
  }
}