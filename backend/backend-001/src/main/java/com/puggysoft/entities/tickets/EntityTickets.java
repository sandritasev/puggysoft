package com.puggysoft.entities.tickets;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tickets")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityTickets extends EntitySuperClass {

  @Column(name = "evento")
  private String evento;
  @Column(name = "uuid")
  private String uuid;
  @Column(name = "used")
  private String used;
  @Column(name = "cliente")
  private String cliente;
  @Column(name = "tenant")
  private String tenant;

}