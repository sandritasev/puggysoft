package com.puggysoft.dtos.asistencia;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.asistencia.EntityAsist;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoAsist extends DtoSuperClass {
  @NotNull
  private String persona;
  @NotNull
  private String detalle;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityAsist dtoToEntity() {
    EntityAsist entity = new EntityAsist();
    entity.setId(id);
    entity.setPersona(persona);
    entity.setDetalle(detalle);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoAsist entityToDto(EntityAsist entity) {
    DtoAsist dto = new DtoAsist();
    dto.setId(entity.getId());
    dto.setPersona(entity.getPersona());
    dto.setDetalle(entity.getDetalle());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
