package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipalesVenta;
import com.puggysoft.entities.alcaldia.EntityAlcaldiaRecursosMunicipalesVenta;
import com.puggysoft.repositories.alcaldia.IRepositoryAlcaldiaRecursosMunicipalesVenta;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get by id. */
@Service
public class ServiceAlcaldiaRecursosMunicipalesVentaGetById {

  @Autowired
  private IRepositoryAlcaldiaRecursosMunicipalesVenta repositoryAlcaldiaRecursosMunicipalesVenta;

  /** method for retrive. */
  public ResponseEntity<DtoAlcaldiaRecursosMunicipalesVenta> getById(Long id) {
    Optional<EntityAlcaldiaRecursosMunicipalesVenta> optionalEntity = repositoryAlcaldiaRecursosMunicipalesVenta
        .findById(id);
    if (optionalEntity.isPresent()) {
      DtoAlcaldiaRecursosMunicipalesVenta dtoControl = DtoAlcaldiaRecursosMunicipalesVenta
          .entityToDto(optionalEntity.get());
      return ResponseEntity.status(HttpStatus.OK).body(dtoControl);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }
}