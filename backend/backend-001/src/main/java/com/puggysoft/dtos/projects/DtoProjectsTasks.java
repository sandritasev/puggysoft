package com.puggysoft.dtos.projects;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.projects.EntityProjectsTasks;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoProjectsTasks extends DtoSuperClass {

  @NotNull
  private String name;
  @NotNull
  private String shortName;
  @NotNull
  private String projectShortName;
  @NotNull
  private String status;
  @NotNull
  private String description;
  @NotNull
  private String responsible;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */
  public EntityProjectsTasks dtoToEntity() {
    EntityProjectsTasks entity = new EntityProjectsTasks();
    entity.setId(id);
    entity.setName(name);
    entity.setShortName(shortName);
    entity.setProjectShortName(projectShortName);
    entity.setStatus(status);
    entity.setDescription(description);
    entity.setShortName(responsible);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */
  public static DtoProjectsTasks entityToDto(EntityProjectsTasks entity) {
    DtoProjectsTasks dto = new DtoProjectsTasks();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setShortName(entity.getShortName());
    dto.setProjectShortName(entity.getProjectShortName());
    dto.setStatus(entity.getStatus());
    dto.setDescription(entity.getDescription());
    dto.setResponsible(entity.getResponsible());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}