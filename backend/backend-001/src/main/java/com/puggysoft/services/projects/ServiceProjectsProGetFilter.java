package com.puggysoft.services.projects;

import com.puggysoft.dtos.projects.DtoProjectsPro;
import com.puggysoft.dtos.projects.DtoProjectsProFilter;
import com.puggysoft.entities.projects.EntityProjectsPro;
import com.puggysoft.repositories.projects.IRepositoryProjectsPro;
import com.puggysoft.tools.projects.SqlProjectsproFilterBuilderNative;
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
public class ServiceProjectsProGetFilter {

  @Autowired
  private IRepositoryProjectsPro repositoryProjectspro;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  public ResponseEntity<List<DtoProjectsPro>> filter(DtoProjectsProFilter dtoProjectsproFilter, int page, int size) {

    String query = SqlProjectsproFilterBuilderNative.build(dtoProjectsproFilter);
    int off = page * size;
    List<EntityProjectsPro> listEntities;
    if (query.equals("")) {
      listEntities = repositoryProjectspro.findProjectsproByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT todo_projects.* FROM todo_projects WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityProjectsPro.class);
      listEntities = (List<EntityProjectsPro>) filterQuery.getResultList();

    }
    List<DtoProjectsPro> listDtoProjectspro = listEntities
        .stream()
        .map(DtoProjectsPro::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoProjectspro);
  }

}
