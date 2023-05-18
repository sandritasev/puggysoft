package com.puggysoft.controllers.tickets;

import com.puggysoft.services.tickets.ServiceTicketsEventosDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTicketsEventosDeleteById {

  @Autowired
  private ServiceTicketsEventosDeleteById serviceTicketsEventosDeleteById;

  @DeleteMapping(path = "/api/v1/tickets-eventos/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceTicketsEventosDeleteById.deleteById(id);
  }
}