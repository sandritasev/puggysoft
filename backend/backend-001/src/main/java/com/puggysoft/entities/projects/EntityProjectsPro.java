package com.puggysoft.entities.projects;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "todo_projects")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityProjectsPro extends EntitySuperClass {

  @Column(name = "name")
  private String name;
  @Column(name = "short_name")
  private String shortName;
  @Column(name = "status")
  private String status;
  @Column(name = "description")
  private String description;
  @Column(name = "responsible")
  private String responsible;
  @Column(name = "tenant")
  private String tenant;

}
