package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageField;
import com.puggysoft.dtos.datastorage.DtoStorageFieldFilter;
import com.puggysoft.entities.datastorage.EntityStorageField;
import com.puggysoft.repositories.datastorage.IRepositoryStorageField;
import com.puggysoft.tools.datastorage.SqlStorageFieldFilterBuilderNative;
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
public class ServiceStorageFieldGetFilter {

  @Autowired
  private IRepositoryStorageField repositoryStorageField;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoStorageField>> filter(
      DtoStorageFieldFilter dtoStorageFieldFilter, int page, int size) {

    String query = SqlStorageFieldFilterBuilderNative.build(dtoStorageFieldFilter);
    int off = page * size;
    List<EntityStorageField> listEntities;
    if (query.equals("")) {
      listEntities = repositoryStorageField.findStorageFieldByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT storage_field.* FROM storage_field WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityStorageField.class);
      listEntities = (List<EntityStorageField>) filterQuery.getResultList();
    }
    List<DtoStorageField> listDtoStorageField = listEntities
        .stream()
        .map(DtoStorageField::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoStorageField);
  }

}