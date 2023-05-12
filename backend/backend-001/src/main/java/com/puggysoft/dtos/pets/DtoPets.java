package com.puggysoft.dtos.pets;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.pets.EntityPets;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoPets extends DtoSuperClass {
  @NotNull
  private String name;
  @NotNull
  private String birthdate;
  @NotNull
  private String sex;
  @NotNull
  private String especie;
  @NotNull
  private String raza;
  @NotNull
  private String color;
  @NotNull
  private String dueno;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityPets dtoToEntity() {
    EntityPets entity = new EntityPets();
    entity.setId(id);
    entity.setName(name);
    entity.setBirthdate(birthdate);
    entity.setSex(sex);
    entity.setEspecie(especie);
    entity.setRaza(raza);
    entity.setColor(color);
    entity.setDueno(dueno);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoPets entityToDto(EntityPets entity) {
    DtoPets dto = new DtoPets();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setBirthdate(entity.getBirthdate());
    dto.setSex(entity.getSex());
    dto.setEspecie(entity.getEspecie());
    dto.setRaza(entity.getRaza());
    dto.setColor(entity.getColor());
    dto.setDueno(entity.getDueno());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
