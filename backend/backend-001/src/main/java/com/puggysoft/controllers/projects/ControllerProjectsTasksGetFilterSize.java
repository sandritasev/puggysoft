package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsTasksFilter;
import com.puggysoft.services.projects.ServiceProjectsTasksGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsTasksGetFilterSize {

  @Autowired
  private ServiceProjectsTasksGetFilterSize serviceProjectstasksGetFilterSize;

  @PostMapping(path = "/api/v1/todo_tasks/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(@RequestBody @Valid DtoProjectsTasksFilter dtoProjectstasksFilter,
      @PathVariable Long pageSize) {
    return serviceProjectstasksGetFilterSize.getSize(dtoProjectstasksFilter, pageSize);
  }

}
