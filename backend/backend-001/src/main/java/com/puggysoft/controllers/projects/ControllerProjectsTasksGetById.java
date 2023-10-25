package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsTasks;
import com.puggysoft.services.projects.ServiceProjectsTasksGetById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsTasksGetById {

  @Autowired
  private ServiceProjectsTasksGetById serviceProjectstasksGetById;

  @GetMapping(path = "/api/v1/todo-tasks/{id}")
  public ResponseEntity<DtoProjectsTasks> getById(@PathVariable Long id) {
    return serviceProjectstasksGetById.getById(id);
  }
}