package com.puggysoft.services.users;

import com.puggysoft.dtos.users.DtoUserFilter;
import com.puggysoft.repositories.users.IRepositoryUser;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.users.SqlUserFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/** Services for get size. */
@Service
public class ServiceUserGetFilterWithoutTenantSize {

  @Autowired
  private IRepositoryUser repositoryUser;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoUserFilter dtoUserFilter, Long pageSize, String tenant) {

    String query = SqlUserFilterBuilderNative.build(dtoUserFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryUser.findSizeWithoutTenants(tenant);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM users WHERE "
          + "users.username NOT IN ( SELECT tenants_users.username FROM tenants_users WHERE tenants_users.tenant = '"
          + tenant + "') AND " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}