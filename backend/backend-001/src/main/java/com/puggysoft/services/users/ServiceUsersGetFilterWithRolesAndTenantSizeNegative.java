package com.puggysoft.services.users;

import com.puggysoft.dtos.users.DtoUserFilter;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.users.SqlUserFilterBuilderNative;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceUsersGetFilterWithRolesAndTenantSizeNegative {

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(
      DtoUserFilter dtoFilter,
      Long pageSize,
      Long idRol,
      String tenant) {
    String query = SqlUserFilterBuilderNative.build(dtoFilter);
    Long totalRows = 0L;
    if (!query.equals("")) {
      query = query.substring(0, query.length() - 4);
      query = "AND " + query + " ";
    }
    String fullQuery = "SELECT COUNT(*) "
        + "FROM users "
        + "INNER JOIN tenants_users ON tenants_users.username=users.username "
        + "WHERE tenants_users.tenant = " + "'" + tenant + "' "
        + "AND users.id "
        + "NOT IN ( "
        + "SELECT users_roles.id_user "
        + "FROM users_roles "
        + "WHERE users_roles.id_role = " + idRol + " AND "
        + "users_roles.tenant = " + "'" + tenant + "'"
        + " ) " + query;
    Query filterQuery = entityManager.createNativeQuery(fullQuery);
    totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
