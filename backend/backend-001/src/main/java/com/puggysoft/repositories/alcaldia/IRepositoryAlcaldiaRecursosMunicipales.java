package com.puggysoft.repositories.alcaldia;

import com.puggysoft.entities.alcaldia.EntityAlcaldiaRecursosMunicipales;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryAlcaldiaRecursosMunicipales extends JpaRepository<EntityAlcaldiaRecursosMunicipales, Long> {

  @Query(value = "SELECT COUNT(*) FROM alcaldia_recursos_municipales;", nativeQuery = true)
  Long findSize();

  @Query(value = "SELECT * FROM alcaldia_recursos_municipales LIMIT ?1, ?2", nativeQuery = true)
  List<EntityAlcaldiaRecursosMunicipales> findAlcaldiaRecursosMunicipalesByPagination(int off, int size);

}