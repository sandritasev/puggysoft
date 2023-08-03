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
public class ServiceUrbanismoTramiteGetByShortName {

  @Autowired
  private IRepositoryUrbanismoTramite repositoryUrbanismoTramite;

  /** method for retrive. */
  public ResponseEntity<DtoUrbanismoTramite> getByShortName(String shortName) {
    Optional<EntityUrbanismoTramite> optionalEntity = repositoryUrbanismoTramite.findByShortName(shortName);
    if (optionalEntity.isPresent()) {
      DtoUrbanismoTramite dto = DtoUrbanismoTramite.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}