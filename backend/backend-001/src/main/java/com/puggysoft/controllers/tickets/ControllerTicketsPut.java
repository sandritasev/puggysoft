package com.puggysoft.controllers.tickets;

import com.puggysoft.dtos.tickets.DtoTickets;
import com.puggysoft.services.tickets.ServiceTicketsEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTicketsPut {

  @Autowired
  private ServiceTicketsEditById serviceTicketsEditById;

  @PutMapping(path = "/api/v1/tickets/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoTickets dtoTickets) {
    return serviceTicketsEditById.editById(id, dtoTickets);
  }
}