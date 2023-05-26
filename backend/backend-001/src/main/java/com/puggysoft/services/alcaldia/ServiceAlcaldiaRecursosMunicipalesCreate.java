package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipales;
import com.puggysoft.entities.alcaldia.EntityAlcaldiaRecursosMunicipales;
import com.puggysoft.repositories.alcaldia.IRepositoryAlcaldiaRecursosMunicipales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceAlcaldiaRecursosMunicipalesCreate {

  @Autowired
  private IRepositoryAlcaldiaRecursosMunicipales repositoryAlcaldiaRecursosMunicipales;

  /** method for create. */
  public ResponseEntity<String> create(DtoAlcaldiaRecursosMunicipales dtoAlcaldiaRecursosMunicipales) {
    try {
      EntityAlcaldiaRecursosMunicipales entity = repositoryAlcaldiaRecursosMunicipales
          .save(dtoAlcaldiaRecursosMunicipales.dtoToEntity());
      DtoAlcaldiaRecursosMunicipales dto = DtoAlcaldiaRecursosMunicipales.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
