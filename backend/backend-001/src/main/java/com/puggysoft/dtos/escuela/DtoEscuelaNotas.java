package com.puggysoft.dtos.escuela;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.escuela.EntityEscuelaNotas;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoEscuelaNotas extends DtoSuperClass {
  @NotNull
  private String name;
  @NotNull
  private String shortName;
  @NotNull
  private String porcentaje;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityEscuelaNotas dtoToEntity() {
    EntityEscuelaNotas entity = new EntityEscuelaNotas();
    entity.setId(id);
    entity.setName(name);
    entity.setShortName(shortName);
    entity.setPorcentaje(porcentaje);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoEscuelaNotas entityToDto(EntityEscuelaNotas entity) {
    DtoEscuelaNotas dto = new DtoEscuelaNotas();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setShortName(entity.getShortName());
    dto.setPorcentaje(entity.getPorcentaje());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
