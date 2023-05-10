package com.puggysoft.controllers.asistencia;

import com.puggysoft.services.asistencia.ServiceAsistDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAsistDeleteById {

  @Autowired
  private ServiceAsistDeleteById serviceAsistDeleteById;

  @DeleteMapping(path = "/api/v1/asist-control/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceAsistDeleteById.deleteById(id);
  }
}
