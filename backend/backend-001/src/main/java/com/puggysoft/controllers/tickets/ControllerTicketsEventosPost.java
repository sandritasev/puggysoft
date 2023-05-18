package com.puggysoft.controllers.tickets;

import com.puggysoft.dtos.tickets.DtoTicketsEventos;
import com.puggysoft.services.tickets.ServiceTicketsEventosCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTicketsEventosPost {
  @Autowired
  private ServiceTicketsEventosCreate serviceTicketsEventosCreate;

  @PostMapping(path = "/api/v1/tickets-eventos")
  public ResponseEntity<String> post(@RequestBody @Valid DtoTicketsEventos dtoTicketsEventos) {
    return serviceTicketsEventosCreate.create(dtoTicketsEventos);
  }
}