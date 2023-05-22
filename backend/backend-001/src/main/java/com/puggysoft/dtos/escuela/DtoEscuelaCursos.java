package com.puggysoft.dtos.escuela;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.escuela.EntityEscuelaCursos;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoEscuelaCursos extends DtoSuperClass {
  @NotNull
  private String name;
  @NotNull
  private String shortName;
  @NotNull
  private String gestion;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityEscuelaCursos dtoToEntity() {
    EntityEscuelaCursos entity = new EntityEscuelaCursos();
    entity.setId(id);
    entity.setName(name);
    entity.setShortName(shortName);
    entity.setGestion(gestion);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoEscuelaCursos entityToDto(EntityEscuelaCursos entity) {
    DtoEscuelaCursos dto = new DtoEscuelaCursos();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setShortName(entity.getShortName());
    dto.setGestion(entity.getGestion());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
