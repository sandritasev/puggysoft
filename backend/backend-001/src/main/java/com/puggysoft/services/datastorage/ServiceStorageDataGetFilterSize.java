package com.puggysoft.services.datastorage;

import com.puggysoft.dtos.datastorage.DtoStorageDataFilter;
import com.puggysoft.repositories.datastorage.IRepositoryStorageData;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.datastorage.SqlStorageDataFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceStorageDataGetFilterSize {

  @Autowired
  private IRepositoryStorageData repositoryStorageData;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoStorageDataFilter dtoStorageDataFilter,
      Long pageSize) {

    String query = SqlStorageDataFilterBuilderNative.build(dtoStorageDataFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryStorageData.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM storage_data WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
