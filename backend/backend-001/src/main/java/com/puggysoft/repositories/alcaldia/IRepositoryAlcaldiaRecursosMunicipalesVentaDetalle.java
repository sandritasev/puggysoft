package com.puggysoft.repositories.alcaldia;

import com.puggysoft.entities.alcaldia.EntityAlcaldiaRecursosMunicipalesVentaDetalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryAlcaldiaRecursosMunicipalesVentaDetalle
    extends JpaRepository<EntityAlcaldiaRecursosMunicipalesVentaDetalle, Long> {

  @Query(value = "SELECT COUNT(*) FROM alcaldia_recursos_municipales_venta_detalle;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM alcaldia_recursos_municipales_venta_detalle LIMIT ?1, ?2", nativeQuery = true)
  List<EntityAlcaldiaRecursosMunicipalesVentaDetalle> findAlcaldiaRecursosMunicipalesVentaDetalleByPagination(int off,
      int size);

}