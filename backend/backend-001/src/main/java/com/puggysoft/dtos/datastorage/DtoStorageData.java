package com.puggysoft.dtos.datastorage;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.datastorage.EntityStorageData;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoStorageData extends DtoSuperClass {
  @NotNull
  private String record;
  @NotNull
  private String field;
  @NotNull
  private String fieldValue;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityStorageData dtoToEntity() {
    EntityStorageData entity = new EntityStorageData();
    entity.setId(id);
    entity.setRecord(record);
    entity.setField(field);
    entity.setFieldValue(fieldValue);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoStorageData entityToDto(EntityStorageData entity) {
    DtoStorageData dto = new DtoStorageData();
    dto.setId(entity.getId());
    dto.setRecord(entity.getRecord());
    dto.setField(entity.getField());
    dto.setFieldValue(entity.getFieldValue());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
