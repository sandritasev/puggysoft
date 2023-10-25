package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsPro;
import com.puggysoft.services.projects.ServiceProjectsProEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsProPut {

  @Autowired
  private ServiceProjectsProEditById serviceProjectsproEditById;

  @PutMapping(path = "/api/v1/todo-projects/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoProjectsPro dtoProjectspro) {
    return serviceProjectsproEditById.editById(id, dtoProjectspro);
  }
}