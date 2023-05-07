package com.puggysoft.dtos.reservations;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.reservations.EntityResResourceSchedule;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* Class.
*/
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoResResourceSchedule extends DtoSuperClass {

  @NotNull
  private Long idSchedule;

  @NotNull
  private Long idResource;

  @Size(min = 3, max = 30)
  @NotNull
  private String tenant;

  /** convert from dto to entity. */
  public EntityResResourceSchedule dtoToEntity() {
    EntityResResourceSchedule entity = new EntityResResourceSchedule();
    entity.setId(id);
    entity.setIdSchedule(idSchedule);
    entity.setIdResource(idResource);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */
  public static DtoResResourceSchedule entityToDto(EntityResResourceSchedule entity) {
    DtoResResourceSchedule dto = new DtoResResourceSchedule();
    dto.setId(entity.getId());
    dto.setIdSchedule(entity.getIdSchedule());
    dto.setIdResource(entity.getIdResource());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}