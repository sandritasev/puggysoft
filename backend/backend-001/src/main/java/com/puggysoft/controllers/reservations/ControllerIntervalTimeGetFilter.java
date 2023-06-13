package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResIntervalTime;
import com.puggysoft.dtos.reservations.DtoResIntervalTimeFilter;
import com.puggysoft.services.reservations.ServiceIntervalTimeGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerIntervalTimeGetFilter {

  @Autowired
  private ServiceIntervalTimeGetFilter serviceIntervalTimeGetFilter;

  @PostMapping(path = "/api/v1/reservations-interval-times/filter")
  public ResponseEntity<List<DtoResIntervalTime>> getIntervalTimeFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoResIntervalTimeFilter dtoIntervalTimeFilter) {
    return serviceIntervalTimeGetFilter.filter(dtoIntervalTimeFilter, page, size);
  }
}
