package com.puggysoft.entities.projects;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "todo_status")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityProjectsStatus extends EntitySuperClass {

  @Column(name = "name")
  private String name;
  @Column(name = "short_name")
  private String shortName;
  @Column(name = "tenant")
  private String tenant;

}
