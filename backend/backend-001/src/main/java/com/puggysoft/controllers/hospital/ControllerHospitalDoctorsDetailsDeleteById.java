package com.puggysoft.controllers.hospital;

import com.puggysoft.services.hospital.ServiceHospitalDoctorsDetailsDeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalDoctorsDetailsDeleteById {

  @Autowired
  private ServiceHospitalDoctorsDetailsDeleteById serviceHospitalDoctorsDetailsDeleteById;

  @DeleteMapping(path = "/api/v1/hospital-doctors-details/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceHospitalDoctorsDetailsDeleteById.deleteById(id);
  }
}