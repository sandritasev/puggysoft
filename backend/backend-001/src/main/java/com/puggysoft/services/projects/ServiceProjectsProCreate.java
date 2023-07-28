package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsPro;
import com.puggysoft.entities.projects.EntityProjectsPro;
import com.puggysoft.repositories.projects.IRepositoryProjectsPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceProjectsProCreate {

  @Autowired
  private IRepositoryProjectsPro repositoryProjectspro;

  /** method for create. */
  public ResponseEntity<String> create(DtoProjectsPro dtoProjectspro) {
    try {
      EntityProjectsPro entity = repositoryProjectspro.save(dtoProjectspro.dtoToEntity());
      DtoProjectsPro dto = DtoProjectsPro.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}