package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsPro;
import com.puggysoft.services.projects.ServiceProjectsProGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsProGetById {

  @Autowired
  private ServiceProjectsProGetById serviceProjectsproGetById;

  @GetMapping(path = "/api/v1/todo_projects/{id}")
  public ResponseEntity<DtoProjectsPro> getById(@PathVariable Long id) {
    return serviceProjectsproGetById.getById(id);
  }
}