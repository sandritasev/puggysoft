package com.puggysoft.controllers.tickets;

import com.puggysoft.dtos.tickets.DtoTicketsEventosFilter;
import com.puggysoft.services.tickets.ServiceTicketsEventosGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTicketsEventosGetFilterSize {

  @Autowired
  private ServiceTicketsEventosGetFilterSize serviceTicketsEventosGetFilterSize;

  @PostMapping(path = "/api/v1/tickets-eventos/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoTicketsEventosFilter dtoTicketsEventosFilter,
      @PathVariable Long pageSize) {
    return serviceTicketsEventosGetFilterSize.getSize(dtoTicketsEventosFilter, pageSize);
  }
}