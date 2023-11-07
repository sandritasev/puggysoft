package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsTasks;
import com.puggysoft.services.projects.ServiceProjectsTasksEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsTasksPut {

  @Autowired
  private ServiceProjectsTasksEditById serviceProjectstasksEditById;

  @PutMapping(path = "/api/v1/todo-tasks/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoProjectsTasks dtoProjectstasks) {
    return serviceProjectstasksEditById.editById(id, dtoProjectstasks);
  }
}