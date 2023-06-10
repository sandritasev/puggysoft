package com.puggysoft.services.system;

import com.puggysoft.dtos.system.DtoTenant;
import com.puggysoft.dtos.system.DtoTenantFilter;
import com.puggysoft.entities.system.EntityTenant;
import com.puggysoft.repositories.system.IRepositoryTenant;
import com.puggysoft.tools.system.SqlTenantFilterBuilderNative;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/** Services for filter tenants. */
@Service
public class ServiceTenantGetFilterWithRole {

  @Autowired
  private IRepositoryTenant repositoryTenant;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter tenants. */
  public ResponseEntity<List<DtoTenant>> filter(DtoTenantFilter dtoTenantFilter, int page, int size, String role) {

    String query = SqlTenantFilterBuilderNative.build(dtoTenantFilter);
    int off = page * size;
    List<EntityTenant> listEntities;
    if (query.equals("")) {
      listEntities = repositoryTenant.findTenantsWithRolesPagination(role, off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT tenants.* FROM tenants "
          + "INNER JOIN tenants_roles ON tenants_roles.tenant=tenants.short_name "
          + "WHERE tenants_roles.role = '" + role + "' AND "
          + query + " LIMIT " + off + "," + size;

      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityTenant.class);
      listEntities = (List<EntityTenant>) filterQuery.getResultList();
    }
    List<DtoTenant> listDtoTenant = listEntities
        .stream()
        .map(DtoTenant::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoTenant);
  }

}
