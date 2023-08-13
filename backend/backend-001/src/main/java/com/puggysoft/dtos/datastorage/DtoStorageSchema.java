package com.puggysoft.dtos.datastorage;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.datastorage.EntityStorageSchema;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoStorageSchema extends DtoSuperClass {
  @NotNull
  private String name;
  @NotNull
  private String shortName;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityStorageSchema dtoToEntity() {
    EntityStorageSchema entity = new EntityStorageSchema();
    entity.setId(id);
    entity.setName(name);
    entity.setShortName(shortName);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoStorageSchema entityToDto(EntityStorageSchema entity) {
    DtoStorageSchema dto = new DtoStorageSchema();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setShortName(entity.getShortName());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
