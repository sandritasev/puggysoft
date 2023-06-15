package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramiteFlujo;
import com.puggysoft.entities.alcaldia.EntityUrbanismoTramiteFlujo;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoTramiteFlujo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceUrbanismoTramiteFlujoGetById {

  @Autowired
  private IRepositoryUrbanismoTramiteFlujo repositoryUrbanismoTramiteFlujo;

  /** method for retrive. */
  public ResponseEntity<DtoUrbanismoTramiteFlujo> getById(Long id) {
    Optional<EntityUrbanismoTramiteFlujo> optionalEntity = repositoryUrbanismoTramiteFlujo.findById(id);
    if (optionalEntity.isPresent()) {
      DtoUrbanismoTramiteFlujo dtoControl = DtoUrbanismoTramiteFlujo.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}