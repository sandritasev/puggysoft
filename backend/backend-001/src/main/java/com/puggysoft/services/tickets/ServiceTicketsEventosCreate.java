package com.puggysoft.services.tickets;

import com.puggysoft.dtos.tickets.DtoTicketsEventos;
import com.puggysoft.entities.tickets.EntityTicketsEventos;
import com.puggysoft.repositories.tickets.IRepositoryTicketsEventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceTicketsEventosCreate {

  @Autowired
  private IRepositoryTicketsEventos repositoryTicketsEventos;

  /** method for create. */
  public ResponseEntity<String> create(DtoTicketsEventos dtoTicketsEventos) {
    try {
      EntityTicketsEventos entity = repositoryTicketsEventos.save(dtoTicketsEventos.dtoToEntity());
      DtoTicketsEventos dto = DtoTicketsEventos.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
