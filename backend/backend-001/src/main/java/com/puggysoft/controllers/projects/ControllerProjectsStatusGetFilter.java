package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsStatus;
import com.puggysoft.dtos.projects.DtoProjectsStatusFilter;
import com.puggysoft.services.projects.ServiceProjectsStatusGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsStatusGetFilter {

  @Autowired
  private ServiceProjectsStatusGetFilter serviceProjectsstatusGetFilter;

  // products/filter?page=${activePage - 1}&size=${pageSize}
  @PostMapping(path = "/api/v1/todo-status/filter")
  public ResponseEntity<List<DtoProjectsStatus>> getProjectsstatusFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoProjectsStatusFilter dtoProjectsstatusFilter) {
    return serviceProjectsstatusGetFilter.filter(dtoProjectsstatusFilter, page, size);
  }
}
