package com.puggysoft.dtos.projects;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.projects.EntityProjectsPro;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoProjectsPro extends DtoSuperClass {

  @NotNull
  private String name;
  @NotNull
  private String shortName;
  @NotNull
  private String status;
  @NotNull
  private String description;
  @NotNull
  private String responsible;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */
  public EntityProjectsPro dtoToEntity() {
    EntityProjectsPro entity = new EntityProjectsPro();
    entity.setId(id);
    entity.setName(name);
    entity.setShortName(shortName);
    entity.setStatus(status);
    entity.setDescription(description);
    entity.setResponsible(responsible);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */
  public static DtoProjectsPro entityToDto(EntityProjectsPro entity) {
    DtoProjectsPro dto = new DtoProjectsPro();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setShortName(entity.getShortName());
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