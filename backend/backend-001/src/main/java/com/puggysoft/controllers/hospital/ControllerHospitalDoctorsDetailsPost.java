package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalDoctorsDetails;
import com.puggysoft.services.hospital.ServiceHospitalDoctorsDetailsCreate;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalDoctorsDetailsPost {
  @Autowired
  private ServiceHospitalDoctorsDetailsCreate serviceHospitalDoctorsDetailsCreate;

  @PostMapping(path = "/api/v1/hospital-doctors-details")
  public ResponseEntity<String> post(@RequestBody @Valid DtoHospitalDoctorsDetails dtoHospitalDoctorsDetails) {
    return serviceHospitalDoctorsDetailsCreate.create(dtoHospitalDoctorsDetails);
  }
}