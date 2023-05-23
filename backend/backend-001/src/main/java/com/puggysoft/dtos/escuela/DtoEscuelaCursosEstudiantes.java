package com.puggysoft.dtos.escuela;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.escuela.EntityEscuelaCursosEstudiantes;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoEscuelaCursosEstudiantes extends DtoSuperClass {
  @NotNull
  private String curso;
  @NotNull
  private String estudiante;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityEscuelaCursosEstudiantes dtoToEntity() {
    EntityEscuelaCursosEstudiantes entity = new EntityEscuelaCursosEstudiantes();
    entity.setId(id);
    entity.setCurso(curso);
    entity.setEstudiante(estudiante);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoEscuelaCursosEstudiantes entityToDto(EntityEscuelaCursosEstudiantes entity) {
    DtoEscuelaCursosEstudiantes dto = new DtoEscuelaCursosEstudiantes();
    dto.setId(entity.getId());
    dto.setCurso(entity.getCurso());
    dto.setEstudiante(entity.getEstudiante());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
