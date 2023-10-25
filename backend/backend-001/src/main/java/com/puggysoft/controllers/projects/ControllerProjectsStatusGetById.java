package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsStatus;
import com.puggysoft.services.projects.ServiceProjectsStatusGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsStatusGetById {

  @Autowired
  private ServiceProjectsStatusGetById serviceProjectsStatusGetById;

  @GetMapping(path = "/api/v1/todo-status/{id}")
  public ResponseEntity<DtoProjectsStatus> getById(@PathVariable Long id) {
    return serviceProjectsStatusGetById.getById(id);
  }
}