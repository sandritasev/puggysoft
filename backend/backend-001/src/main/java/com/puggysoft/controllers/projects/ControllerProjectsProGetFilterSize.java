package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsProFilter;
import com.puggysoft.services.projects.ServiceProjectsProGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsProGetFilterSize {

  @Autowired
  private ServiceProjectsProGetFilterSize serviceProjectsProGetFilterSize;

  @PostMapping(path = "/api/v1/todo_projects/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoProjectsProFilter dtoProjectsproFilter,
      @PathVariable Long pageSize) {
    return serviceProjectsProGetFilterSize.getSize(dtoProjectsproFilter, pageSize);
  }

}
