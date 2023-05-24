package com.puggysoft.services.users;

import com.puggysoft.dtos.users.DtoUser;
import com.puggysoft.dtos.users.DtoUserFilter;
import com.puggysoft.entities.users.EntityUser;
import com.puggysoft.repositories.users.IRepositoryUser;
import com.puggysoft.tools.users.SqlUserFilterBuilderNative;
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
public class ServiceUserGetFilterWithRolesAndTenant {

  @Autowired
  private IRepositoryUser repositoryUser;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter users. */
  public ResponseEntity<List<DtoUser>> filter(
      DtoUserFilter dtoUserFilter,
      int page,
      int size,
      Long idRol,
      String tenant
  ) {
    String query = SqlUserFilterBuilderNative.build(dtoUserFilter);
    int off = page * size;
    List<EntityUser> listEntities;
    if (query.equals("")) {
      listEntities = repositoryUser.findUsersWithRoleAndTenant(idRol, off, size, tenant);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT users.* FROM users "
          + "INNER JOIN users_roles ON users_roles.id_user=users.id "
          + "INNER JOIN tenants_users ON tenants_users.username=users.username "
          + "WHERE users_roles.id_role = " + idRol + " AND "
          + "tenants_users.tenant = " + "'" + tenant + "'" + " AND "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityUser.class);
      listEntities = (List<EntityUser>) filterQuery.getResultList();
    }
    List<DtoUser> listDtoUser = listEntities
        .stream()
        .map(DtoUser::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoUser);
  }

}
