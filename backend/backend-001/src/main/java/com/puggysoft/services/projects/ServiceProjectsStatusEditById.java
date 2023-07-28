package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsStatus;
import com.puggysoft.repositories.projects.IRepositoryProjectsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceProjectsStatusEditById {

  @Autowired
  private IRepositoryProjectsStatus repositoryProjectsstatus;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoProjectsStatus dtoProjectsstatus) {
    if (repositoryProjectsstatus.existsById(id)) {
      try {
        dtoProjectsstatus.setId(id.longValue());
        repositoryProjectsstatus.save(dtoProjectsstatus.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}