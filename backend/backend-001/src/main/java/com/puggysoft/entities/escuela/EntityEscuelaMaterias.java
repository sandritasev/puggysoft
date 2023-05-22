package com.puggysoft.entities.escuela;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "escuela_materias")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityEscuelaMaterias extends EntitySuperClass {

  @Column(name = "name")
  private String name;
  @Column(name = "short_name")
  private String shortName;
  @Column(name = "nota_maxima")
  private String notaMaxima;
  @Column(name = "tenant")
  private String tenant;

}