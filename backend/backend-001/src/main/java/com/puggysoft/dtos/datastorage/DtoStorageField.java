package com.puggysoft.dtos.datastorage;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.datastorage.EntityStorageField;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoStorageField extends DtoSuperClass {
  @NotNull
  private String name;
  @NotNull
  private String shortName;
  @NotNull
  private String type;
  @NotNull
  private String textboxOption;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityStorageField dtoToEntity() {
    EntityStorageField entity = new EntityStorageField();
    entity.setId(id);
    entity.setName(name);
    entity.setShortName(shortName);
    entity.setType(type);
    entity.setTextboxOption(textboxOption);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoStorageField entityToDto(EntityStorageField entity) {
    DtoStorageField dto = new DtoStorageField();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setShortName(entity.getShortName());
    dto.setType(entity.getType());
    dto.setTextboxOption(entity.getTextboxOption());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
