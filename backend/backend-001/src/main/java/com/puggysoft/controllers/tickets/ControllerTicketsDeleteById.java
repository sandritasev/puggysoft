package com.puggysoft.controllers.tickets;

import com.puggysoft.services.tickets.ServiceTicketsDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTicketsDeleteById {

  @Autowired
  private ServiceTicketsDeleteById serviceTicketsDeleteById;

  @DeleteMapping(path = "/api/v1/tickets/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceTicketsDeleteById.deleteById(id);
  }
}