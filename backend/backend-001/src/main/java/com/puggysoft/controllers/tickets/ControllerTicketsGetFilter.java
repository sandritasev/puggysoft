package com.puggysoft.controllers.tickets;

import com.puggysoft.dtos.tickets.DtoTickets;
import com.puggysoft.dtos.tickets.DtoTicketsFilter;
import com.puggysoft.services.tickets.ServiceTicketsGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTicketsGetFilter {

  @Autowired
  private ServiceTicketsGetFilter serviceTicketsGetFilter;

  @PostMapping(path = "/api/v1/tickets/filter")
  public ResponseEntity<List<DtoTickets>> getTicketsFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoTicketsFilter dtoTicketsFilter) {
    return serviceTicketsGetFilter.filter(dtoTicketsFilter, page, size);
  }
}