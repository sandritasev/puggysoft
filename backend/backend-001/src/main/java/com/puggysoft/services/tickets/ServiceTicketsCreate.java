package com.puggysoft.services.tickets;

import com.puggysoft.dtos.tickets.DtoTickets;
import com.puggysoft.entities.tickets.EntityTickets;
import com.puggysoft.repositories.tickets.IRepositoryTickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceTicketsCreate {

  @Autowired
  private IRepositoryTickets repositoryTickets;

  /** method for create. */
  public ResponseEntity<String> create(DtoTickets dtoTickets) {
    try {
      EntityTickets entity = repositoryTickets.save(dtoTickets.dtoToEntity());
      DtoTickets dto = DtoTickets.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
