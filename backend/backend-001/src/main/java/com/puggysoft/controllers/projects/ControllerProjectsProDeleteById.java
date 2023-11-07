package com.puggysoft.controllers.projects;

import com.puggysoft.services.projects.ServiceProjectsProDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsProDeleteById {

  @Autowired
  private ServiceProjectsProDeleteById serviceProjectsproDeleteById;

  @DeleteMapping(path = "/api/v1/todo-projects/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceProjectsproDeleteById.deleteById(id);
  }
}
