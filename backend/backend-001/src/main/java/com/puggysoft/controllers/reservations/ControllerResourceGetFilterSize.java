package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResResourceFilter;
import com.puggysoft.services.reservations.ServiceResourceGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerResourceGetFilterSize {

  @Autowired
  private ServiceResourceGetFilterSize serviceResourceGetFilterSize;

  @PostMapping(path = "/api/v1/reservations-resources/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoResResourceFilter dtoResResourceFilter,
      @PathVariable Long pageSize) {
    return serviceResourceGetFilterSize.getSize(dtoResResourceFilter, pageSize);
  }
}