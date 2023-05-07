package com.puggysoft.repositories.system;

import com.puggysoft.entities.system.EntityTenantUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRepositoryTenantUser extends JpaRepository<EntityTenantUser, Long> {

}
