package com.puggysoft.controllers.projects;

import com.puggysoft.services.projects.ServiceProjectsStatusDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsStatusDeleteById {

  @Autowired
  private ServiceProjectsStatusDeleteById serviceProjectsstatusDeleteById;

  @DeleteMapping(path = "/api/v1/todo_status/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceProjectsstatusDeleteById.deleteById(id);
  }
}
