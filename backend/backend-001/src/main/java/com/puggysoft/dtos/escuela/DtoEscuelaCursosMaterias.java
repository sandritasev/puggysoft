package com.puggysoft.dtos.escuela;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.escuela.EntityEscuelaCursosMaterias;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoEscuelaCursosMaterias extends DtoSuperClass {
  @NotNull
  private String curso;
  @NotNull
  private String materia;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityEscuelaCursosMaterias dtoToEntity() {
    EntityEscuelaCursosMaterias entity = new EntityEscuelaCursosMaterias();
    entity.setId(id);
    entity.setCurso(curso);
    entity.setMateria(materia);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoEscuelaCursosMaterias entityToDto(EntityEscuelaCursosMaterias entity) {
    DtoEscuelaCursosMaterias dto = new DtoEscuelaCursosMaterias();
    dto.setId(entity.getId());
    dto.setCurso(entity.getCurso());
    dto.setMateria(entity.getMateria());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
