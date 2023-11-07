package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsStatus;
import com.puggysoft.services.projects.ServiceProjectsStatusCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsStatusPost {

  @Autowired
  private ServiceProjectsStatusCreate serviceProjectsstatusCreate;

  @PostMapping(path = "/api/v1/todo-status")
  public ResponseEntity<String> post(@RequestBody @Valid DtoProjectsStatus dtoProjectsstatus) {
    return serviceProjectsstatusCreate.create(dtoProjectsstatus);
  }
}
