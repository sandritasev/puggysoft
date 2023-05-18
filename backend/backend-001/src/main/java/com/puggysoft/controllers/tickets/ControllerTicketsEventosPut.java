package com.puggysoft.controllers.tickets;

import com.puggysoft.dtos.tickets.DtoTicketsEventos;
import com.puggysoft.services.tickets.ServiceTicketsEventosEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTicketsEventosPut {

  @Autowired
  private ServiceTicketsEventosEditById serviceTicketsEventosEditById;

  @PutMapping(path = "/api/v1/tickets-eventos/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoTicketsEventos dtoTicketsEventos) {
    return serviceTicketsEventosEditById.editById(id, dtoTicketsEventos);
  }
}