package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipales;
import com.puggysoft.dtos.alcaldia.DtoAlcaldiaRecursosMunicipalesFilter;
import com.puggysoft.entities.alcaldia.EntityAlcaldiaRecursosMunicipales;
import com.puggysoft.repositories.alcaldia.IRepositoryAlcaldiaRecursosMunicipales;
import com.puggysoft.tools.alcaldia.SqlAlcaldiaRecursosMunicipalesFilterBuilderNative;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for filter. */
@Service
public class ServiceAlcaldiaRecursosMunicipalesHijoNotByPadreIdGetFilter {

  @Autowired
  private IRepositoryAlcaldiaRecursosMunicipales repositoryAlcaldiaRecursosMunicipales;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoAlcaldiaRecursosMunicipales>> filter(
      DtoAlcaldiaRecursosMunicipalesFilter dtoAlcaldiaRecursosMunicipalesFilter, int page, int size, Long idPadre) {

    String query = SqlAlcaldiaRecursosMunicipalesFilterBuilderNative.build(dtoAlcaldiaRecursosMunicipalesFilter);
    int off = page * size;
    List<EntityAlcaldiaRecursosMunicipales> listEntities;
    if (query.equals("")) {
      listEntities = repositoryAlcaldiaRecursosMunicipales.findAlcaldiaRecursosMunicipalesHijoNotByPadreId(off, size, idPadre);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT DISTINCT alcaldia_recursos_municipales.* FROM alcaldia_recursos_municipales "
      + "WHERE alcaldia_recursos_municipales.tipo = \"HIJO\" AND "
      + "alcaldia_recursos_municipales.id NOT IN (SELECT alcaldia_recursos_municipales.id FROM alcaldia_recursos_municipales "
      + "INNER JOIN alcaldia_recursos_municipales_grupo_para_reportes ON alcaldia_recursos_municipales.id = alcaldia_recursos_municipales_grupo_para_reportes.id_recurso_municipal_hijo "
      + "WHERE alcaldia_recursos_municipales_grupo_para_reportes.id_recurso_municipal_padre = " + idPadre + ") AND alcaldia_recursos_municipales.id " 
      + "NOT IN (SELECT id FROM alcaldia_recursos_municipales WHERE name = (SELECT alcaldia_recursos_municipales.name FROM alcaldia_recursos_municipales INNER JOIN alcaldia_recursos_municipales_grupo_para_reportes "
      + "ON alcaldia_recursos_municipales_grupo_para_reportes.id_recurso_municipal_hijo = alcaldia_recursos_municipales.id "
      + "WHERE alcaldia_recursos_municipales_grupo_para_reportes.id_recurso_municipal_padre = " + idPadre + " AND alcaldia_recursos_municipales_grupo_para_reportes.id_recurso_municipal_hijo = "
      + "(SELECT id FROM `alcaldia_recursos_municipales` WHERE name LIKE \"%TIMBRES%\" LIMIT 1))) AND "
      + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityAlcaldiaRecursosMunicipales.class);
      listEntities = (List<EntityAlcaldiaRecursosMunicipales>) filterQuery.getResultList();
    }
    List<DtoAlcaldiaRecursosMunicipales> listDtoAlcaldiaRecursosMunicipales = listEntities
        .stream()
        .map(DtoAlcaldiaRecursosMunicipales::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoAlcaldiaRecursosMunicipales);
  }

}