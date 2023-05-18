package com.puggysoft.services.tickets;

import com.puggysoft.dtos.tickets.DtoTicketsEventos;
import com.puggysoft.repositories.tickets.IRepositoryTicketsEventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceTicketsEventosEditById {

  @Autowired
  private IRepositoryTicketsEventos repositoryTicketsEventos;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoTicketsEventos dtoTicketsEventos) {
    if (repositoryTicketsEventos.existsById(id)) {
      try {
        dtoTicketsEventos.setId(id.longValue());
        repositoryTicketsEventos.save(dtoTicketsEventos.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}