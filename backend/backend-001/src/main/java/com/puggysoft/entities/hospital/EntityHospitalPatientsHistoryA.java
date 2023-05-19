package com.puggysoft.entities.hospital;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "hospital_patients_history_a")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityHospitalPatientsHistoryA extends EntitySuperClass {

  @Column(name = "presionArterial")
  private String presionArterial;
  @Column(name = "frecuenciaCardiaca")
  private String frecuenciaCardiaca;
  @Column(name = "saturacionOxigeno")
  private String saturacionOxigeno;
  @Column(name = "altura")
  private String altura;
  @Column(name = "weight")
  private String weight;
  @Column(name = "temperatura")
  private String temperatura;
  @Column(name = "antecedentes")
  private String antecedentes;
  @Column(name = "diagnostico")
  private String diagnostico;
  @Column(name = "tratamiento")
  private String tratamiento;
  @Column(name = "patient_username")
  private String patientUsername;
  @Column(name = "tenant")
  private String tenant;

}