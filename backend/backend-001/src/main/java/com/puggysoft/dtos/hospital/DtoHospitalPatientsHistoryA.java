package com.puggysoft.dtos.hospital;

import com.puggysoft.dtos.DtoSuperClass;
import com.puggysoft.entities.hospital.EntityHospitalPatientsHistoryA;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DtoHospitalPatientsHistoryA extends DtoSuperClass {
  @NotNull
  private String presionArterial;
  @NotNull
  private String frecuenciaCardiaca;
  @NotNull
  private String saturacionOxigeno;
  @NotNull
  private String altura;
  @NotNull
  private String weight;
  @NotNull
  private String temperatura;
  @NotNull
  private String antecedentes;
  @NotNull
  private String diagnostico;
  @NotNull
  private String tratamiento;
  @NotNull
  private String patientUsername;
  @NotNull
  private String tenant;

  /** convert from dto to entity. */

  public EntityHospitalPatientsHistoryA dtoToEntity() {
    EntityHospitalPatientsHistoryA entity = new EntityHospitalPatientsHistoryA();
    entity.setId(id);
    entity.setPresionArterial(presionArterial);
    entity.setFrecuenciaCardiaca(frecuenciaCardiaca);
    entity.setSaturacionOxigeno(saturacionOxigeno);
    entity.setAltura(altura);
    entity.setWeight(weight);
    entity.setTemperatura(temperatura);
    entity.setAntecedentes(antecedentes);
    entity.setDiagnostico(diagnostico);
    entity.setTratamiento(tratamiento);
    entity.setPatientUsername(patientUsername);
    entity.setTenant(tenant);
    entity.setCreatedBy(createdBy);
    entity.setUpdatedBy(updatedBy);
    return entity;
  }

  /** convert from entity to dto. */

  public static DtoHospitalPatientsHistoryA entityToDto(EntityHospitalPatientsHistoryA entity) {
    DtoHospitalPatientsHistoryA dto = new DtoHospitalPatientsHistoryA();
    dto.setId(entity.getId());
    dto.setPresionArterial(entity.getPresionArterial());
    dto.setFrecuenciaCardiaca(entity.getFrecuenciaCardiaca());
    dto.setSaturacionOxigeno(entity.getSaturacionOxigeno());
    dto.setAltura(entity.getAltura());
    dto.setWeight(entity.getWeight());
    dto.setTemperatura(entity.getTemperatura());
    dto.setAntecedentes(entity.getAntecedentes());
    dto.setDiagnostico(entity.getDiagnostico());
    dto.setTratamiento(entity.getTratamiento());
    dto.setPatientUsername(entity.getPatientUsername());
    dto.setTenant(entity.getTenant());
    dto.setCreatedBy(entity.getCreatedBy());
    dto.setUpdatedBy(entity.getUpdatedBy());
    dto.setCreationDate(entity.getCreationDate());
    dto.setUpdateDate(entity.getUpdateDate());
    return dto;
  }
}
