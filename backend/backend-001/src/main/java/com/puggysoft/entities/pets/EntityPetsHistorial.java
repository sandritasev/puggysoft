package com.puggysoft.entities.pets;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pets_historial")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityPetsHistorial extends EntitySuperClass {

  @Column(name = "diagnostico")
  private String diagnostico;
  @Column(name = "tratamiento")
  private String tratamiento;
  @Column(name = "weight")
  private String weight;
  @Column(name = "petId")
  private String petId;
  @Column(name = "tenant")
  private String tenant;

}