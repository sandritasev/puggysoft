package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsPro;
import com.puggysoft.entities.projects.EntityProjectsPro;
import com.puggysoft.repositories.projects.IRepositoryProjectsPro;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceProjectsProGetById {

  @Autowired
  private IRepositoryProjectsPro repositoryProjectspro;

  /** method for retrive. */
  public ResponseEntity<DtoProjectsPro> getById(Long id) {
    Optional<EntityProjectsPro> optionalEntity = repositoryProjectspro.findById(id);
    if (optionalEntity.isPresent()) {
      DtoProjectsPro dtoProduct = DtoProjectsPro.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoProduct);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}