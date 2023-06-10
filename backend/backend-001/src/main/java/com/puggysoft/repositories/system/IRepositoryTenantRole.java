package com.puggysoft.repositories.system;

import com.puggysoft.entities.system.EntityTenantRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IRepositoryTenantRole extends JpaRepository<EntityTenantRole, Long> {

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM tenants_roles WHERE role = :role AND tenant = :tenant", nativeQuery = true)
  void deleteTenantRoleByKeys(@Param("role") String role, @Param("tenant") String tenant);

  @Query(value = "SELECT * FROM tenants_roles WHERE role = :role AND tenant = :tenant", nativeQuery = true)
  List<EntityTenantRole> findByKeys(@Param("role") String role, @Param("tenant") String tenant);

}
