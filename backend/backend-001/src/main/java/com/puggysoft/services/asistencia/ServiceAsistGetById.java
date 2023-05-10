package com.puggysoft.services.asistencia;

import com.puggysoft.dtos.asistencia.DtoAsist;
import com.puggysoft.entities.asistencia.EntityAsist;
import com.puggysoft.repositories.asistencia.IRepositoryAsist;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceAsistGetById {

  @Autowired
  private IRepositoryAsist repositoryAsist;

  /** method for retrive. */
  public ResponseEntity<DtoAsist> getById(Long id) {
    Optional<EntityAsist> optionalEntity = repositoryAsist.findById(id);
    if (optionalEntity.isPresent()) {
      DtoAsist dtoControl = DtoAsist.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}
