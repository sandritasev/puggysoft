package com.puggysoft.entities.pets;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pets_pets")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityPets extends EntitySuperClass {

  @Column(name = "name")
  private String name;
  @Column(name = "birthdate")
  private String birthdate;
  @Column(name = "sex")
  private String sex;
  @Column(name = "especie")
  private String especie;
  @Column(name = "raza")
  private String raza;
  @Column(name = "color")
  private String color;
  @Column(name = "dueno")
  private String dueno;
  @Column(name = "tenant")
  private String tenant;

}