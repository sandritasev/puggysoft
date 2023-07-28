package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsStatus;
import com.puggysoft.entities.projects.EntityProjectsStatus;
import com.puggysoft.repositories.projects.IRepositoryProjectsStatus;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceProjectsStatusGetById {

  @Autowired
  private IRepositoryProjectsStatus repositoryProjectsstatus;

  /** method for retrive. */
  public ResponseEntity<DtoProjectsStatus> getById(Long id) {
    Optional<EntityProjectsStatus> optionalEntity = repositoryProjectsstatus.findById(id);
    if (optionalEntity.isPresent()) {
      DtoProjectsStatus dtoProduct = DtoProjectsStatus.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoProduct);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}