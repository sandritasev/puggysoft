package com.puggysoft.dtos.reservations;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.reservations.EntityResIntervalTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* Class.
*/
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoResIntervalTime extends DtoSuperClass {

  @NotNull
  @Size(min = 3, max = 60)
  private String name;

  @NotNull
  @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$")
  private String  startTime;

  @NotNull
  @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$")
  private String  endTime;

  @Size(min = 3, max = 30)
  @NotNull
  private String tenant;

  /** convert from dto to entity. */
  public EntityResIntervalTime dtoToEntity() {
    EntityResIntervalTime entity = new EntityResIntervalTime();
    entity.setId(id);
    entity.setName(name);
    entity.setStartTime(startTime);
    entity.setEndTime(endTime);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */
  public static DtoResIntervalTime entityToDto(EntityResIntervalTime entity) {
    DtoResIntervalTime dto = new DtoResIntervalTime();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setStartTime(entity.getStartTime());
    dto.setEndTime(entity.getEndTime());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}