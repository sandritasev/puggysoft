package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipalesVenta;
import com.puggysoft.repositories.alcaldia.IRepositoryAlcaldiaRecursosMunicipalesVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Services for edit by id. */
@Service
public class ServiceAlcaldiaRecursosMunicipalesVentaEditById {

  @Autowired
  private IRepositoryAlcaldiaRecursosMunicipalesVenta repositoryAlcaldiaRecursosMunicipalesVenta;

  /** method for edit. */
  @Transactional
  public ResponseEntity<String> editById(Long id,
      DtoAlcaldiaRecursosMunicipalesVenta dtoAlcaldiaRecursosMunicipalesVenta) {
    if (repositoryAlcaldiaRecursosMunicipalesVenta.existsById(id)) {
      try {
        dtoAlcaldiaRecursosMunicipalesVenta.setId(id.longValue());
        repositoryAlcaldiaRecursosMunicipalesVenta.save(dtoAlcaldiaRecursosMunicipalesVenta.dtoToEntity());
        return ResponseEntity.status(HttpStatus.OK).body("Updated successfully");
      } catch (DataAccessException ex) {
        String dbException = ex.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
      }
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
  }
}