package com.puggysoft.entities.datastorage;

import com.puggysoft.entities.EntitySuperClass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "storage_field")
@Data
@EqualsAndHashCode(callSuper = true)
public class EntityStorageField extends EntitySuperClass {

  @Column(name = "name")
  private String name;
  @Column(name = "short_name")
  private String shortName;
  @Column(name = "type")
  private String type;
  @Column(name = "textbox_option")
  private String textboxOption;
  @Column(name = "tenant")
  private String tenant;

}