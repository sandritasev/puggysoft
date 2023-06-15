package com.puggysoft.dtos.alcaldia;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.alcaldia.EntityUrbanismoHistorial;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoUrbanismoHistorial extends DtoSuperClass {
  @NotNull
  private String idTramiteFlujo;
  @NotNull
  private String username;
  @NotNull
  private String estadoAnterior;
  @NotNull
  private String estadoNuevo;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityUrbanismoHistorial dtoToEntity() {
    EntityUrbanismoHistorial entity = new EntityUrbanismoHistorial();
    entity.setId(id);
    entity.setIdTramiteFlujo(idTramiteFlujo);
    entity.setUsername(username);
    entity.setEstadoAnterior(estadoAnterior);
    entity.setEstadoNuevo(estadoNuevo);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoUrbanismoHistorial entityToDto(EntityUrbanismoHistorial entity) {
    DtoUrbanismoHistorial dto = new DtoUrbanismoHistorial();
    dto.setId(entity.getId());
    dto.setIdTramiteFlujo(entity.getIdTramiteFlujo());
    dto.setUsername(entity.getUsername());
    dto.setEstadoAnterior(entity.getEstadoAnterior());
    dto.setEstadoNuevo(entity.getEstadoNuevo());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
