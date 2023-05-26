package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipales;
import com.puggysoft.entities.alcaldia.EntityAlcaldiaRecursosMunicipales;
import com.puggysoft.repositories.alcaldia.IRepositoryAlcaldiaRecursosMunicipales;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceAlcaldiaRecursosMunicipalesGetById {

  @Autowired
  private IRepositoryAlcaldiaRecursosMunicipales repositoryAlcaldiaRecursosMunicipales;

  /** method for retrive. */
  public ResponseEntity<DtoAlcaldiaRecursosMunicipales> getById(Long id) {
    Optional<EntityAlcaldiaRecursosMunicipales> optionalEntity = repositoryAlcaldiaRecursosMunicipales.findById(id);
    if (optionalEntity.isPresent()) {
      DtoAlcaldiaRecursosMunicipales dtoControl = DtoAlcaldiaRecursosMunicipales.entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}