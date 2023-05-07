package com.puggysoft.dtos.users;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.users.EntityUserRole;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* Class.
*/
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoUserRole extends DtoSuperClass {

  @NotNull
  private Long idUser;

  @NotNull
  private Long idRole;

  @Size(min = 3, max = 30)
  @NotNull
  private String tenant;

  /** convert from dto to entity. */
  public EntityUserRole dtoToEntity() {
    EntityUserRole entity = new EntityUserRole();
    entity.setId(id);
    entity.setIdUser(idUser);
    entity.setIdRole(idRole);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */
  public static DtoUserRole entityToDto(EntityUserRole entity) {
    DtoUserRole dto = new DtoUserRole();
    dto.setId(entity.getId());
    dto.setIdUser(entity.getIdUser());
    dto.setIdRole(entity.getIdRole());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
