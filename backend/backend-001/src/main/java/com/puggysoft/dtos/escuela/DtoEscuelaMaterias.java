package com.puggysoft.dtos.escuela;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.escuela.EntityEscuelaMaterias;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoEscuelaMaterias extends DtoSuperClass {
  @NotNull
  private String name;
  @NotNull
  private String shortName;
  @NotNull
  private String notaMaxima;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityEscuelaMaterias dtoToEntity() {
    EntityEscuelaMaterias entity = new EntityEscuelaMaterias();
    entity.setId(id);
    entity.setName(name);
    entity.setShortName(shortName);
    entity.setNotaMaxima(notaMaxima);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoEscuelaMaterias entityToDto(EntityEscuelaMaterias entity) {
    DtoEscuelaMaterias dto = new DtoEscuelaMaterias();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setShortName(entity.getShortName());
    dto.setNotaMaxima(entity.getNotaMaxima());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
