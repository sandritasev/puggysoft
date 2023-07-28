package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsTasks;
import com.puggysoft.entities.projects.EntityProjectsTasks;
import com.puggysoft.repositories.projects.IRepositoryProjectsTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceProjectsTasksCreate {

  @Autowired
  private IRepositoryProjectsTasks repositoryProjectstasks;

  /** method for create. */
  public ResponseEntity<String> create(DtoProjectsTasks dtoProjectstasks) {
    try {
      EntityProjectsTasks entity = repositoryProjectstasks.save(dtoProjectstasks.dtoToEntity());
      DtoProjectsTasks dto = DtoProjectsTasks.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}