package com.puggysoft.repositories.system;

import com.puggysoft.entities.system.EntityTenantUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IRepositoryTenantUser extends JpaRepository<EntityTenantUser, Long> {

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM tenants_users WHERE username = :username AND tenant = :tenant", nativeQuery = true)
  void deleteTenantUserByKeys(@Param("username") String username, @Param("tenant") String tenant);

  @Query(value = "SELECT * FROM tenants_users WHERE username = :username AND tenant = :tenant", nativeQuery = true)
  List<EntityTenantUser> findByKeys(@Param("username") String username, @Param("tenant") String tenant);

}
