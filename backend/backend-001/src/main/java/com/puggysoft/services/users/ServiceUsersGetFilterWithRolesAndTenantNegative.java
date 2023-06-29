package com.puggysoft.services.users;

import com.puggysoft.dtos.users.DtoUser;
import com.puggysoft.dtos.users.DtoUserFilter;
import com.puggysoft.entities.users.EntityUser;
import com.puggysoft.tools.users.SqlUserFilterBuilderNative;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for filter users. */
@Service
public class ServiceUsersGetFilterWithRolesAndTenantNegative {

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter users. */
  @SuppressWarnings("unchecked")
  public ResponseEntity<List<DtoUser>> filter(
      DtoUserFilter dtoFilter,
      int page,
      int size,
      Long idRol,
      String tenant) {
    String query = SqlUserFilterBuilderNative.build(dtoFilter);
    int off = page * size;
    List<EntityUser> listEntities;
    if (!query.equals("")) {
      query = query.substring(0, query.length() - 4);
      query = "AND " + query + " ";
    }
    // Delete last 'AND' key workd.
    String fullQuery = "SELECT users.* "
        + "FROM users "
        + "INNER JOIN tenants_users ON tenants_users.username=users.username "
        + "WHERE tenants_users.tenant = " + "'" + tenant + "' "
        + "AND users.id "
        + "NOT IN ( "
        + "SELECT users_roles.id_user "
        + "FROM users_roles "
        + "WHERE users_roles.id_role = " + idRol + " AND "
        + "users_roles.tenant = " + "'" + tenant + "'"
        + " ) " + query
        + " LIMIT " + off + "," + size;
    // JQPL (createQuery) and Native (createNativeQuery)
    Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityUser.class);
    listEntities = (List<EntityUser>) filterQuery.getResultList();
    List<DtoUser> listDto = listEntities
        .stream()
        .map(DtoUser::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDto);
  }

}
