package com.puggysoft.dtos.hospital;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.hospital.EntityHospitalPatientsDetails;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoHospitalPatientsDetails extends DtoSuperClass {
  @NotNull
  private String username;
  @NotNull
  private String susCode;

  /** convert from dto to entity. */

  public EntityHospitalPatientsDetails dtoToEntity() {
    EntityHospitalPatientsDetails entity = new EntityHospitalPatientsDetails();
    entity.setId(id);
    entity.setUsername(username);
    entity.setSusCode(susCode);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoHospitalPatientsDetails entityToDto(EntityHospitalPatientsDetails entity) {
    DtoHospitalPatientsDetails dto = new DtoHospitalPatientsDetails();
    dto.setId(entity.getId());
    dto.setUsername(entity.getUsername());
    dto.setSusCode(entity.getSusCode());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
