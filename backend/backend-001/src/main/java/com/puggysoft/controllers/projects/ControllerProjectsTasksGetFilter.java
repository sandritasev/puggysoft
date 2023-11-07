package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsTasks;
import com.puggysoft.dtos.projects.DtoProjectsTasksFilter;
import com.puggysoft.services.projects.ServiceProjectsTasksGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsTasksGetFilter {

  @Autowired
  private ServiceProjectsTasksGetFilter serviceProjectsTasksGetFilter;

  // products/filter?page=${activePage - 1}&size=${pageSize}
  @PostMapping(path = "/api/v1/todo-tasks/filter")
  public ResponseEntity<List<DtoProjectsTasks>> getProjectstasksFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoProjectsTasksFilter dtoProjectstasksFilter) {
    return serviceProjectsTasksGetFilter.filter(dtoProjectstasksFilter, page, size);
  }
}
