package com.puggysoft.controllers.projects;

import com.puggysoft.services.projects.ServiceProjectsTasksDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsTasksDeleteById {

  @Autowired
  private ServiceProjectsTasksDeleteById serviceProjectsTasksDeleteById;

  @DeleteMapping(path = "/api/v1/todo-tasks/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceProjectsTasksDeleteById.deleteById(id);
  }
}
