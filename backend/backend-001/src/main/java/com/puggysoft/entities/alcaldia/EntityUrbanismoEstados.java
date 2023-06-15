package com.puggysoft.entities.alcaldia;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "alc_urb_estados")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityUrbanismoEstados extends EntitySuperClass {

  @Column(name = "nombre")
  private String nombre;
  @Column(name = "nombre_corto")
  private String nombreCorto;
  @Column(name = "tenant")
  private String tenant;

}