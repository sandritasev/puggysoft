package com.puggysoft.services.users;

import com.puggysoft.dtos.users.DtoRoleFilter;
import com.puggysoft.repositories.users.IRepositoryRole;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.users.SqlRoleFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/** Services for get size. */
@Service
public class ServiceRolesGetFilterWithUsersAndTenantSizeNegative {

  @Autowired
  private IRepositoryRole repositoryRole;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(
      DtoRoleFilter dtoFilter,
      Long pageSize,
      Long idUser,
      String tenant
  ) {
    String query = SqlRoleFilterBuilderNative.build(dtoFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryRole.findSizeWithUserAndTenantNegative(idUser, tenant);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) "
          + "FROM roles "
          + "INNER JOIN tenants_roles ON tenants_roles.role=roles.name "
          + "WHERE tenants_roles.tenant = " + "'" + tenant + "' "
          + "AND roles.id "
          + "NOT IN ("
          + "SELECT users_roles.id_role "
          + "FROM users_roles "
          + "WHERE users_roles.id_user = " + idUser + " AND "
          + "users_roles.tenant = " + "'" + tenant + "'"
          + ") AND "
          + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}