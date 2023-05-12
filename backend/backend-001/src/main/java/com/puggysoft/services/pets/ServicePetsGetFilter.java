package com.puggysoft.services.pets;

import com.puggysoft.dtos.pets.DtoPets;
import com.puggysoft.dtos.pets.DtoPetsFilter;
import com.puggysoft.entities.pets.EntityPets;
import com.puggysoft.repositories.pets.IRepositoryPets;
import com.puggysoft.tools.pets.SqlPetsFilterBuilderNative;
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
public class ServicePetsGetFilter {

  @Autowired
  private IRepositoryPets repositoryPets;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoPets>> filter(DtoPetsFilter dtoPetsFilter, int page, int size) {

    String query = SqlPetsFilterBuilderNative.build(dtoPetsFilter);
    int off = page * size;
    List<EntityPets> listEntities;
    if (query.equals("")) {
      listEntities = repositoryPets.findPetsByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT pets_pets.* FROM pets_pets WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityPets.class);
      listEntities = (List<EntityPets>) filterQuery.getResultList();
    }
    List<DtoPets> listDtoPets = listEntities
        .stream()
        .map(DtoPets::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoPets);
  }

}