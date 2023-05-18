package com.puggysoft.entities.tickets;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tickets_eventos")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityTicketsEventos extends EntitySuperClass {

  @Column(name = "nombre")
  private String nombre;
  @Column(name = "short_name")
  private String shortName;
  @Column(name = "cantidad_tickets")
  private String cantidadTickets;
  @Column(name = "fecha_fin")
  private String fechaFin;
  @Column(name = "fecha_inicio")
  private String fechaInicio;
  @Column(name = "aux")
  private String aux;
  @Column(name = "tenant")
  private String tenant;

}