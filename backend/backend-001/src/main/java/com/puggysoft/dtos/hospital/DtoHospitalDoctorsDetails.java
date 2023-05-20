package com.puggysoft.dtos.hospital;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.hospital.EntityHospitalDoctorsDetails;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoHospitalDoctorsDetails extends DtoSuperClass {
  @NotNull
  private String username;
  @NotNull
  private String specialization;

  /** convert from dto to entity. */

  public EntityHospitalDoctorsDetails dtoToEntity() {
    EntityHospitalDoctorsDetails entity = new EntityHospitalDoctorsDetails();
    entity.setId(id);
    entity.setUsername(username);
    entity.setSpecialization(specialization);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoHospitalDoctorsDetails entityToDto(EntityHospitalDoctorsDetails entity) {
    DtoHospitalDoctorsDetails dto = new DtoHospitalDoctorsDetails();
    dto.setId(entity.getId());
    dto.setUsername(entity.getUsername());
    dto.setSpecialization(entity.getSpecialization());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
