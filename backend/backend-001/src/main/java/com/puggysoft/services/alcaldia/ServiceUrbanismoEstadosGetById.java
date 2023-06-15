package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstados;
import com.puggysoft.entities.alcaldia.EntityUrbanismoEstados;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoEstados;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceUrbanismoEstadosGetById {

  @Autowired
  private IRepositoryUrbanismoEstados repositoryUrbanismoEstados;

  /** method for retrive. */
  public ResponseEntity<DtoUrbanismoEstados> getById(Long id) {
    Optional<EntityUrbanismoEstados> optionalEntity = repositoryUrbanismoEstados.findById(id);
    if (optionalEntity.isPresent()) {
      DtoUrbanismoEstados dtoControl = DtoUrbanismoEstados.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}