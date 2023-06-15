package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoRequisitos;
import com.puggysoft.entities.alcaldia.EntityUrbanismoRequisitos;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoRequisitos;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceUrbanismoRequisitosGetById {

  @Autowired
  private IRepositoryUrbanismoRequisitos repositoryUrbanismoRequisitos;

  /** method for retrive. */
  public ResponseEntity<DtoUrbanismoRequisitos> getById(Long id) {
    Optional<EntityUrbanismoRequisitos> optionalEntity = repositoryUrbanismoRequisitos.findById(id);
    if (optionalEntity.isPresent()) {
      DtoUrbanismoRequisitos dtoControl = DtoUrbanismoRequisitos.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}