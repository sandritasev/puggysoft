package com.puggysoft.services.tickets;

import com.puggysoft.dtos.tickets.DtoTickets;
import com.puggysoft.repositories.tickets.IRepositoryTickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceTicketsEditById {

  @Autowired
  private IRepositoryTickets repositoryTickets;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoTickets dtoTickets) {
    if (repositoryTickets.existsById(id)) {
      try {
        dtoTickets.setId(id.longValue());
        repositoryTickets.save(dtoTickets.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}