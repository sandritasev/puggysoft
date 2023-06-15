package com.puggysoft.dtos.alcaldia;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.alcaldia.EntityUrbanismoFlujoRequisitos;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoUrbanismoFlujoRequisitos extends DtoSuperClass {
  @NotNull
  private String idTramiteFlujo;
  @NotNull
  private String requisitoNombreCorto;
  @NotNull
  private String estado;
  private String archivoRequisito;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityUrbanismoFlujoRequisitos dtoToEntity() {
    EntityUrbanismoFlujoRequisitos entity = new EntityUrbanismoFlujoRequisitos();
    entity.setId(id);
    entity.setIdTramiteFlujo(idTramiteFlujo);
    entity.setRequisitoNombreCorto(requisitoNombreCorto);
    entity.setEstado(estado);
    entity.setArchivoRequisito(archivoRequisito);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoUrbanismoFlujoRequisitos entityToDto(EntityUrbanismoFlujoRequisitos entity) {
    DtoUrbanismoFlujoRequisitos dto = new DtoUrbanismoFlujoRequisitos();
    dto.setId(entity.getId());
    dto.setIdTramiteFlujo(entity.getIdTramiteFlujo());
    dto.setRequisitoNombreCorto(entity.getRequisitoNombreCorto());
    dto.setEstado(entity.getEstado());
    dto.setArchivoRequisito(entity.getArchivoRequisito());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
