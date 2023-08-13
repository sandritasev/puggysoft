package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchemaField;
import com.puggysoft.dtos.datastorage.DtoStorageSchemaFieldFilter;
import com.puggysoft.entities.datastorage.EntityStorageSchemaField;
import com.puggysoft.repositories.datastorage.IRepositoryStorageSchemaField;
import com.puggysoft.tools.datastorage.SqlStorageSchemaFieldFilterBuilderNative;
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
public class ServiceStorageSchemaFieldGetFilter {

  @Autowired
  private IRepositoryStorageSchemaField repositoryStorageSchemaField;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoStorageSchemaField>> filter(
      DtoStorageSchemaFieldFilter dtoStorageSchemaFieldFilter, int page, int size) {

    String query = SqlStorageSchemaFieldFilterBuilderNative.build(dtoStorageSchemaFieldFilter);
    int off = page * size;
    List<EntityStorageSchemaField> listEntities;
    if (query.equals("")) {
      listEntities = repositoryStorageSchemaField.findStorageSchemaFieldByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT storage_schema_field.* FROM storage_schema_field WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityStorageSchemaField.class);
      listEntities = (List<EntityStorageSchemaField>) filterQuery.getResultList();
    }
    List<DtoStorageSchemaField> listDtoStorageSchemaField = listEntities
        .stream()
        .map(DtoStorageSchemaField::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoStorageSchemaField);
  }

}