package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsStatus;
import com.puggysoft.services.projects.ServiceProjectsStatusEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsStatusPut {

  @Autowired
  private ServiceProjectsStatusEditById serviceProjectsStatusEditById;

  @PutMapping(path = "/api/v1/todo_status/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoProjectsStatus dtoProjectsstatus) {
    return serviceProjectsStatusEditById.editById(id, dtoProjectsstatus);
  }
}