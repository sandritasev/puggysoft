package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsTasks;
import com.puggysoft.services.projects.ServiceProjectsTasksCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsTasksPost {

  @Autowired
  private ServiceProjectsTasksCreate serviceProjectstasksCreate;

  @PostMapping(path = "/api/v1/todo-tasks")
  public ResponseEntity<String> post(@RequestBody @Valid DtoProjectsTasks dtoProjectstasks) {
    return serviceProjectstasksCreate.create(dtoProjectstasks);
  }
}
