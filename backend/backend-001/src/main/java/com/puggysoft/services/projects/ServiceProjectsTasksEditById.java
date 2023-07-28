package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsTasks;
import com.puggysoft.repositories.projects.IRepositoryProjectsTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceProjectsTasksEditById {

  @Autowired
  private IRepositoryProjectsTasks repositoryProjectstasks;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoProjectsTasks dtoProjectstasks) {
    if (repositoryProjectstasks.existsById(id)) {
      try {
        dtoProjectstasks.setId(id.longValue());
        repositoryProjectstasks.save(dtoProjectstasks.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}