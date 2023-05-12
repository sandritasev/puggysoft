package com.puggysoft.services.system;

import com.puggysoft.dtos.system.DtoTenantFilter;
import com.puggysoft.repositories.system.IRepositoryTenant;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.system.SqlTenantFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/** Services for get size. */
@Service
public class ServiceTenantGetFilterWithUserSize {

  @Autowired
  private IRepositoryTenant repositoryTenant;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoTenantFilter dtoTenantFilter, Long pageSize, String username) {

    String query = SqlTenantFilterBuilderNative.build(dtoTenantFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryTenant.findSizeWithUsers(username);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM tenants "
          + "INNER JOIN tenants_users ON tenants_users.tenant=tenants.short_name "
          + "WHERE tenants_users.username = '" + username + "' AND " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}