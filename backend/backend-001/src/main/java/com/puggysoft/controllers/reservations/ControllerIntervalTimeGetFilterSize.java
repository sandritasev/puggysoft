package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResIntervalTimeFilter;
import com.puggysoft.services.reservations.ServiceIntervalTimeGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerIntervalTimeGetFilterSize {

  @Autowired
  private ServiceIntervalTimeGetFilterSize serviceIntervalTimeGetFilterSize;

  @PostMapping(path = "/api/v1/reservations-interval-times/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoResIntervalTimeFilter dtoResIntervalTimeFilter,
      @PathVariable Long pageSize) {
    return serviceIntervalTimeGetFilterSize.getSize(dtoResIntervalTimeFilter,
        pageSize);
  }
}