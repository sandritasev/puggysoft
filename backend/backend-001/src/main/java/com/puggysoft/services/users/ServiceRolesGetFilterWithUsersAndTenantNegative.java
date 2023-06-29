package com.puggysoft.services.users;

import com.puggysoft.dtos.users.DtoRole;
import com.puggysoft.dtos.users.DtoRoleFilter;
import com.puggysoft.entities.users.EntityRole;
import com.puggysoft.repositories.users.IRepositoryRole;
import com.puggysoft.tools.users.SqlRoleFilterBuilderNative;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/** Services for filter users. */
@Service
public class ServiceRolesGetFilterWithUsersAndTenantNegative {

  @Autowired
  private IRepositoryRole repositoryRole;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter users. */
  @SuppressWarnings("unchecked")
  public ResponseEntity<List<DtoRole>> filter(
      DtoRoleFilter dtoFilter,
      int page,
      int size,
      Long idUser,
      String tenant
  ) {
    String query = SqlRoleFilterBuilderNative.build(dtoFilter);
    int off = page * size;
    List<EntityRole> listEntities;
    if (query.equals("")) {
      listEntities = repositoryRole.findRolesWithUserAndTenantNegative(idUser, off, size, tenant);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT roles.* "
          + "FROM roles "
          + "INNER JOIN tenants_roles ON tenants_roles.role=roles.name "
          + "WHERE tenants_roles.tenant = " + "'" + tenant + "' "
          + "AND roles.id "
          + "NOT IN ( "
          + "SELECT users_roles.id_role "
          + "FROM users_roles "
          + "WHERE users_roles.id_user = " + idUser + " AND "
          + "users_roles.tenant = " + "'" + tenant + "'"
          + " ) AND "
          + query
          + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityRole.class);
      listEntities = (List<EntityRole>) filterQuery.getResultList();
    }
    List<DtoRole> listDto = listEntities
        .stream()
        .map(DtoRole::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDto);
  }

}
