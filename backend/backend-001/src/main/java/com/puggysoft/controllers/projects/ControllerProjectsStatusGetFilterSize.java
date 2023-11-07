package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsStatusFilter;
import com.puggysoft.services.projects.ServiceProjectsStatusGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsStatusGetFilterSize {

  @Autowired
  private ServiceProjectsStatusGetFilterSize serviceProjectsStatusGetFilterSize;

  @PostMapping(path = "/api/v1/todo-status/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoProjectsStatusFilter dtoProjectsstatusFilter,
      @PathVariable Long pageSize) {
    return serviceProjectsStatusGetFilterSize.getSize(dtoProjectsstatusFilter, pageSize);
  }

}
