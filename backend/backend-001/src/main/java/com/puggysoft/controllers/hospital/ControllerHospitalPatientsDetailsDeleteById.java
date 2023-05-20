package com.puggysoft.controllers.hospital;

import com.puggysoft.services.hospital.ServiceHospitalPatientsDetailsDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalPatientsDetailsDeleteById {

  @Autowired
  private ServiceHospitalPatientsDetailsDeleteById serviceHospitalPatientsDetailsDeleteById;

  @DeleteMapping(path = "/api/v1/hospital-patients-details/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceHospitalPatientsDetailsDeleteById.deleteById(id);
  }
}