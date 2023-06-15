package com.puggysoft.dtos.alcaldia;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.alcaldia.EntityUrbanismoRequisitos;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoUrbanismoRequisitos extends DtoSuperClass {
  @NotNull
  private String nombre;
  @NotNull
  private String nombreCorto;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityUrbanismoRequisitos dtoToEntity() {
    EntityUrbanismoRequisitos entity = new EntityUrbanismoRequisitos();
    entity.setId(id);
    entity.setNombre(nombre);
    entity.setNombreCorto(nombreCorto);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoUrbanismoRequisitos entityToDto(EntityUrbanismoRequisitos entity) {
    DtoUrbanismoRequisitos dto = new DtoUrbanismoRequisitos();
    dto.setId(entity.getId());
    dto.setNombre(entity.getNombre());
    dto.setNombreCorto(entity.getNombreCorto());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
