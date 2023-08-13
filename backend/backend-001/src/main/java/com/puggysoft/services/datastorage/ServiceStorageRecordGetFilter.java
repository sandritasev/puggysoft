package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageRecord;
import com.puggysoft.dtos.datastorage.DtoStorageRecordFilter;
import com.puggysoft.entities.datastorage.EntityStorageRecord;
import com.puggysoft.repositories.datastorage.IRepositoryStorageRecord;
import com.puggysoft.tools.datastorage.SqlStorageRecordFilterBuilderNative;
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
public class ServiceStorageRecordGetFilter {

  @Autowired
  private IRepositoryStorageRecord repositoryStorageRecord;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoStorageRecord>> filter(
      DtoStorageRecordFilter dtoStorageRecordFilter, int page, int size) {

    String query = SqlStorageRecordFilterBuilderNative.build(dtoStorageRecordFilter);
    int off = page * size;
    List<EntityStorageRecord> listEntities;
    if (query.equals("")) {
      listEntities = repositoryStorageRecord.findStorageRecordByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT storage_record.* FROM storage_record WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityStorageRecord.class);
      listEntities = (List<EntityStorageRecord>) filterQuery.getResultList();
    }
    List<DtoStorageRecord> listDtoStorageRecord = listEntities
        .stream()
        .map(DtoStorageRecord::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoStorageRecord);
  }

}