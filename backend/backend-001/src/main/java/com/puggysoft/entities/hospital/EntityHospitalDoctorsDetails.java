package com.puggysoft.entities.hospital;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "hospital_doctors_details")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityHospitalDoctorsDetails extends EntitySuperClass {

  @Column(name = "username")
  private String username;
  @Column(name = "specialization")
  private String specialization;

}