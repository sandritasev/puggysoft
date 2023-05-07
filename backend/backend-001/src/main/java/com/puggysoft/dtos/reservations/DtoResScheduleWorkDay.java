package com.puggysoft.dtos.reservations;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.reservations.EntityResScheduleWorkDay;
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
public class DtoResScheduleWorkDay extends DtoSuperClass {

  @NotNull
  private Long idSchedule;

  @NotNull
  @Pattern(regexp = "(SUNDAY|MONDAY|TUESDAY|WEDNESDAY|THURSDAY|FRIDAY|SATURDAY)")
  private String workDay;

  @Size(min = 3, max = 30)
  @NotNull
  private String tenant;

  /** convert from dto to entity. */
  public EntityResScheduleWorkDay dtoToEntity() {
    EntityResScheduleWorkDay entity = new EntityResScheduleWorkDay();
    entity.setId(id);
    entity.setIdSchedule(idSchedule);
    entity.setWorkDay(workDay);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */
  public static DtoResScheduleWorkDay entityToDto(EntityResScheduleWorkDay entity) {
    DtoResScheduleWorkDay dto = new DtoResScheduleWorkDay();
    dto.setId(entity.getId());
    dto.setIdSchedule(entity.getIdSchedule());
    dto.setWorkDay(entity.getWorkDay());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}