package com.puggysoft.dtos.datastorage;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.datastorage.EntityStorageRecord;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoStorageRecord extends DtoSuperClass {
  @NotNull
  private String shortName;
  @NotNull
  private String schema;
  @NotNull
  private String aux;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityStorageRecord dtoToEntity() {
    EntityStorageRecord entity = new EntityStorageRecord();
    entity.setId(id);
    entity.setShortName(shortName);
    entity.setSchema(schema);
    entity.setAux(aux);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoStorageRecord entityToDto(EntityStorageRecord entity) {
    DtoStorageRecord dto = new DtoStorageRecord();
    dto.setId(entity.getId());
    dto.setShortName(entity.getShortName());
    dto.setSchema(entity.getSchema());
    dto.setAux(entity.getAux());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
