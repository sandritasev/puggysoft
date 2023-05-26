package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipalesVenta;
import com.puggysoft.entities.alcaldia.EntityAlcaldiaRecursosMunicipalesVenta;
import com.puggysoft.repositories.alcaldia.IRepositoryAlcaldiaRecursosMunicipalesVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceAlcaldiaRecursosMunicipalesVentaCreate {

  @Autowired
  private IRepositoryAlcaldiaRecursosMunicipalesVenta repositoryAlcaldiaRecursosMunicipalesVenta;

  /** method for create. */
  public ResponseEntity<String> create(DtoAlcaldiaRecursosMunicipalesVenta dtoAlcaldiaRecursosMunicipalesVenta) {
    try {
      EntityAlcaldiaRecursosMunicipalesVenta entity = repositoryAlcaldiaRecursosMunicipalesVenta
          .save(dtoAlcaldiaRecursosMunicipalesVenta.dtoToEntity());
      DtoAlcaldiaRecursosMunicipalesVenta dto = DtoAlcaldiaRecursosMunicipalesVenta.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
