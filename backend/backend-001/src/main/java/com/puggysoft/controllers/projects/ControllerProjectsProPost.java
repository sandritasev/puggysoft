package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsPro;
import com.puggysoft.services.projects.ServiceProjectsProCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsProPost {

  @Autowired
  private ServiceProjectsProCreate serviceProjectsproCreate;

  @PostMapping(path = "/api/v1/todo-projects")
  public ResponseEntity<String> post(@RequestBody @Valid DtoProjectsPro dtoProjectspro) {
    return serviceProjectsproCreate.create(dtoProjectspro);
  }
}
