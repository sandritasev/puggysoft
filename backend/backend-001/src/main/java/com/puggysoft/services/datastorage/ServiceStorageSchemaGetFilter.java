package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageSchema;
import com.puggysoft.dtos.datastorage.DtoStorageSchemaFilter;
import com.puggysoft.entities.datastorage.EntityStorageSchema;
import com.puggysoft.repositories.datastorage.IRepositoryStorageSchema;
import com.puggysoft.tools.datastorage.SqlStorageSchemaFilterBuilderNative;
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
public class ServiceStorageSchemaGetFilter {

  @Autowired
  private IRepositoryStorageSchema repositoryStorageSchema;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoStorageSchema>> filter(
      DtoStorageSchemaFilter dtoStorageSchemaFilter, int page, int size) {

    String query = SqlStorageSchemaFilterBuilderNative.build(dtoStorageSchemaFilter);
    int off = page * size;
    List<EntityStorageSchema> listEntities;
    if (query.equals("")) {
      listEntities = repositoryStorageSchema.findStorageSchemaByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT storage_schema.* FROM storage_schema WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityStorageSchema.class);
      listEntities = (List<EntityStorageSchema>) filterQuery.getResultList();
    }
    List<DtoStorageSchema> listDtoStorageSchema = listEntities
        .stream()
        .map(DtoStorageSchema::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoStorageSchema);
  }

}