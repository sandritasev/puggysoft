package com.puggysoft.controllers.tickets;

import com.puggysoft.dtos.tickets.DtoTickets;
import com.puggysoft.services.tickets.ServiceTicketsCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTicketsPost {
  @Autowired
  private ServiceTicketsCreate serviceTicketsCreate;

  @PostMapping(path = "/api/v1/tickets")
  public ResponseEntity<String> post(@RequestBody @Valid DtoTickets dtoTickets) {
    return serviceTicketsCreate.create(dtoTickets);
  }
}