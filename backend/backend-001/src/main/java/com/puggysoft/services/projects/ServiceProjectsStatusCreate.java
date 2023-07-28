package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsStatus;
import com.puggysoft.entities.projects.EntityProjectsStatus;
import com.puggysoft.repositories.projects.IRepositoryProjectsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceProjectsStatusCreate {

  @Autowired
  private IRepositoryProjectsStatus repositoryProjectsstatus;

  /** method for create. */
  public ResponseEntity<String> create(DtoProjectsStatus dtoProjectsstatus) {
    try {
      EntityProjectsStatus entity = repositoryProjectsstatus.save(dtoProjectsstatus.dtoToEntity());
      DtoProjectsStatus dto = DtoProjectsStatus.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}