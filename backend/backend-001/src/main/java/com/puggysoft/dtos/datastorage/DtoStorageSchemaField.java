package com.puggysoft.dtos.datastorage;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.datastorage.EntityStorageSchemaField;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoStorageSchemaField extends DtoSuperClass {
  @NotNull
  private String schema;
  @NotNull
  private String field;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityStorageSchemaField dtoToEntity() {
    EntityStorageSchemaField entity = new EntityStorageSchemaField();
    entity.setId(id);
    entity.setSchema(schema);
    entity.setField(field);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoStorageSchemaField entityToDto(EntityStorageSchemaField entity) {
    DtoStorageSchemaField dto = new DtoStorageSchemaField();
    dto.setId(entity.getId());
    dto.setSchema(entity.getSchema());
    dto.setField(entity.getField());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
