package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipalesVentaDetalle;
import com.puggysoft.entities.alcaldia.EntityAlcaldiaRecursosMunicipalesVentaDetalle;
import com.puggysoft.repositories.alcaldia.IRepositoryAlcaldiaRecursosMunicipalesVentaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for create. */
@Service
public class ServiceAlcaldiaRecursosMunicipalesVentaDetalleCreate {

  @Autowired
  private IRepositoryAlcaldiaRecursosMunicipalesVentaDetalle repositoryAlcaldiaRecursosMunicipalesVentaDetalle;

  /** method for create. */
  public ResponseEntity<String> create(
      DtoAlcaldiaRecursosMunicipalesVentaDetalle dtoAlcaldiaRecursosMunicipalesVentaDetalle) {
    try {
      EntityAlcaldiaRecursosMunicipalesVentaDetalle entity = repositoryAlcaldiaRecursosMunicipalesVentaDetalle
          .save(dtoAlcaldiaRecursosMunicipalesVentaDetalle.dtoToEntity());
      DtoAlcaldiaRecursosMunicipalesVentaDetalle dto = DtoAlcaldiaRecursosMunicipalesVentaDetalle.entityToDto(entity);
      String idString = String.valueOf(dto.getId());
      return ResponseEntity.status(HttpStatus.CREATED).body(idString);
    } catch (DataAccessException ex) {
      String dbException = ex.getMostSpecificCause().getMessage();
      return ResponseEntity.status(HttpStatus.CONFLICT).body(dbException);
    }
  }
}
