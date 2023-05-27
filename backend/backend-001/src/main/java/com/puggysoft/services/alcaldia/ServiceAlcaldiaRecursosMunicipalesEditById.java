package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipales;
import com.puggysoft.repositories.alcaldia.IRepositoryAlcaldiaRecursosMunicipales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceAlcaldiaRecursosMunicipalesEditById {

  @Autowired
  private IRepositoryAlcaldiaRecursosMunicipales repositoryAlcaldiaRecursosMunicipales;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id, DtoAlcaldiaRecursosMunicipales dtoAlcaldiaRecursosMunicipales) {
    if (repositoryAlcaldiaRecursosMunicipales.existsById(id)) {
      try {
        dtoAlcaldiaRecursosMunicipales.setId(id.longValue());
        repositoryAlcaldiaRecursosMunicipales.save(dtoAlcaldiaRecursosMunicipales.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}