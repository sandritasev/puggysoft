package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoTramite;
import com.puggysoft.entities.alcaldia.EntityUrbanismoTramite;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoTramite;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceUrbanismoTramiteGetById {

  @Autowired
  private IRepositoryUrbanismoTramite repositoryUrbanismoTramite;

  /** method for retrive. */
  public ResponseEntity<DtoUrbanismoTramite> getById(Long id) {
    Optional<EntityUrbanismoTramite> optionalEntity = repositoryUrbanismoTramite.findById(id);
    if (optionalEntity.isPresent()) {
      DtoUrbanismoTramite dtoControl = DtoUrbanismoTramite.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}