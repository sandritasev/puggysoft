package com.puggysoft.dtos.alcaldia;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.alcaldia.EntityUrbanismoTramiteRequisitos;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoUrbanismoTramiteRequisitos extends DtoSuperClass {
  @NotNull
  private String tramiteNombreCorto;
  @NotNull
  private String requisitoNombreCorto;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityUrbanismoTramiteRequisitos dtoToEntity() {
    EntityUrbanismoTramiteRequisitos entity = new EntityUrbanismoTramiteRequisitos();
    entity.setId(id);
    entity.setTramiteNombreCorto(tramiteNombreCorto);
    entity.setRequisitoNombreCorto(requisitoNombreCorto);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoUrbanismoTramiteRequisitos entityToDto(EntityUrbanismoTramiteRequisitos entity) {
    DtoUrbanismoTramiteRequisitos dto = new DtoUrbanismoTramiteRequisitos();
    dto.setId(entity.getId());
    dto.setTramiteNombreCorto(entity.getTramiteNombreCorto());
    dto.setRequisitoNombreCorto(entity.getRequisitoNombreCorto());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
