package com.puggysoft.controllers.tickets;

import com.puggysoft.dtos.tickets.DtoTicketsEventos;
import com.puggysoft.dtos.tickets.DtoTicketsEventosFilter;
import com.puggysoft.services.tickets.ServiceTicketsEventosGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTicketsEventosGetFilter {

  @Autowired
  private ServiceTicketsEventosGetFilter serviceTicketsEventosGetFilter;

  @PostMapping(path = "/api/v1/tickets-eventos/filter")
  public ResponseEntity<List<DtoTicketsEventos>> getTicketsEventosFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoTicketsEventosFilter dtoTicketsEventosFilter) {
    return serviceTicketsEventosGetFilter.filter(dtoTicketsEventosFilter, page, size);
  }
}