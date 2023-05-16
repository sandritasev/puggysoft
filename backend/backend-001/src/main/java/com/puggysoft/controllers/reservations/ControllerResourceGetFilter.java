package com.puggysoft.controllers.reservations;

import com.puggysoft.dtos.reservations.DtoResResource;
import com.puggysoft.dtos.reservations.DtoResResourceFilter;
import com.puggysoft.services.reservations.ServiceResourceGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerResourceGetFilter {

  @Autowired
  private ServiceResourceGetFilter serviceResourceGetFilter;

  @PostMapping(path = "/api/v1/reservations-resources/filter")
  public ResponseEntity<List<DtoResResource>> getResourceFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoResResourceFilter dtoResourceFilter) {
    return serviceResourceGetFilter.filter(dtoResourceFilter, page, size);
  }
}