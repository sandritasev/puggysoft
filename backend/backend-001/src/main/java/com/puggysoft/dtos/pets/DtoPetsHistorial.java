package com.puggysoft.dtos.pets;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.pets.EntityPetsHistorial;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoPetsHistorial extends DtoSuperClass {
  @NotNull
  private String diagnostico;
  @NotNull
  private String tratamiento;
  @NotNull
  private String weight;
  @NotNull
  private String petId;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityPetsHistorial dtoToEntity() {
    EntityPetsHistorial entity = new EntityPetsHistorial();
    entity.setId(id);
    entity.setDiagnostico(diagnostico);
    entity.setTratamiento(tratamiento);
    entity.setWeight(weight);
    entity.setPetId(petId);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoPetsHistorial entityToDto(EntityPetsHistorial entity) {
    DtoPetsHistorial dto = new DtoPetsHistorial();
    dto.setId(entity.getId());
    dto.setDiagnostico(entity.getDiagnostico());
    dto.setTratamiento(entity.getTratamiento());
    dto.setWeight(entity.getWeight());
    dto.setPetId(entity.getPetId());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
