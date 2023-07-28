package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsTasks;
import com.puggysoft.entities.projects.EntityProjectsTasks;
import com.puggysoft.repositories.projects.IRepositoryProjectsTasks;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceProjectsTasksGetById {

  @Autowired
  private IRepositoryProjectsTasks repositoryProjectstasks;

  /** method for retrive. */
  public ResponseEntity<DtoProjectsTasks> getById(Long id) {
    Optional<EntityProjectsTasks> optionalEntity = repositoryProjectstasks.findById(id);
    if (optionalEntity.isPresent()) {
      DtoProjectsTasks dtoProduct = DtoProjectsTasks.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoProduct);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}