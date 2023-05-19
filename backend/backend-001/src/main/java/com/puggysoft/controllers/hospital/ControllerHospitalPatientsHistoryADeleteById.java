package com.puggysoft.controllers.hospital;

import com.puggysoft.services.hospital.ServiceHospitalPatientsHistoryADeleteById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalPatientsHistoryADeleteById {

  @Autowired
  private ServiceHospitalPatientsHistoryADeleteById serviceHospitalPatientsHistoryADeleteById;

  @DeleteMapping(path = "/api/v1/hospital-patients-history-a/{id}")
  public ResponseEntity<String> deleteById(@PathVariable Long id) {
    return serviceHospitalPatientsHistoryADeleteById.deleteById(id);
  }
}