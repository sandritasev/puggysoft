package com.puggysoft.dtos.alcaldia;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.alcaldia.EntityAlcaldiaRecursosMunicipales;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoAlcaldiaRecursosMunicipales extends DtoSuperClass {
  @NotNull
  @Size(min = 3, max = 30)
  private String codigo;
  @NotNull
  private String name;
  @NotNull
  private String precio;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityAlcaldiaRecursosMunicipales dtoToEntity() {
    EntityAlcaldiaRecursosMunicipales entity = new EntityAlcaldiaRecursosMunicipales();
    entity.setId(id);
    entity.setCodigo(codigo);
    entity.setName(name);
    entity.setPrecio(precio);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoAlcaldiaRecursosMunicipales entityToDto(EntityAlcaldiaRecursosMunicipales entity) {
    DtoAlcaldiaRecursosMunicipales dto = new DtoAlcaldiaRecursosMunicipales();
    dto.setId(entity.getId());
    dto.setCodigo(entity.getCodigo());
    dto.setName(entity.getName());
    dto.setPrecio(entity.getPrecio());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
