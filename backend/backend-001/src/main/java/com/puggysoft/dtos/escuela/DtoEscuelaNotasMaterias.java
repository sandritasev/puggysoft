package com.puggysoft.dtos.escuela;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.escuela.EntityEscuelaNotasMaterias;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoEscuelaNotasMaterias extends DtoSuperClass {
  @NotNull
  private String materia;
  @NotNull
  private String nota;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityEscuelaNotasMaterias dtoToEntity() {
    EntityEscuelaNotasMaterias entity = new EntityEscuelaNotasMaterias();
    entity.setId(id);
    entity.setMateria(materia);
    entity.setNota(nota);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoEscuelaNotasMaterias entityToDto(EntityEscuelaNotasMaterias entity) {
    DtoEscuelaNotasMaterias dto = new DtoEscuelaNotasMaterias();
    dto.setId(entity.getId());
    dto.setMateria(entity.getMateria());
    dto.setNota(entity.getNota());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
