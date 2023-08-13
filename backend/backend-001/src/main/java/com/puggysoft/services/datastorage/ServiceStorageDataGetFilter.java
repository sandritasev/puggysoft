package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageData;
import com.puggysoft.dtos.datastorage.DtoStorageDataFilter;
import com.puggysoft.entities.datastorage.EntityStorageData;
import com.puggysoft.repositories.datastorage.IRepositoryStorageData;
import com.puggysoft.tools.datastorage.SqlStorageDataFilterBuilderNative;
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
public class ServiceStorageDataGetFilter {

  @Autowired
  private IRepositoryStorageData repositoryStorageData;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoStorageData>> filter(
      DtoStorageDataFilter dtoStorageDataFilter, int page, int size) {

    String query = SqlStorageDataFilterBuilderNative.build(dtoStorageDataFilter);
    int off = page * size;
    List<EntityStorageData> listEntities;
    if (query.equals("")) {
      listEntities = repositoryStorageData.findStorageDataByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT storage_data.* FROM storage_data WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityStorageData.class);
      listEntities = (List<EntityStorageData>) filterQuery.getResultList();
    }
    List<DtoStorageData> listDtoStorageData = listEntities
        .stream()
        .map(DtoStorageData::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoStorageData);
  }

}