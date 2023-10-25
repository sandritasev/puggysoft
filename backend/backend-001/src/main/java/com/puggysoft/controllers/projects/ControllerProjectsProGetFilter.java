package com.puggysoft.controllers.projects;

import com.puggysoft.dtos.projects.DtoProjectsPro;
import com.puggysoft.dtos.projects.DtoProjectsProFilter;
import com.puggysoft.services.projects.ServiceProjectsProGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProjectsProGetFilter {

  @Autowired
  private ServiceProjectsProGetFilter serviceProjectsProGetFilterS;

  // products/filter?page=${activePage - 1}&size=${pageSize}
  @PostMapping(path = "/api/v1/todo-projects/filter")
  public ResponseEntity<List<DtoProjectsPro>> getProjectsproFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoProjectsProFilter dtoProjectsproFilter) {
    return serviceProjectsProGetFilterS.filter(dtoProjectsproFilter, page, size);
  }
}
