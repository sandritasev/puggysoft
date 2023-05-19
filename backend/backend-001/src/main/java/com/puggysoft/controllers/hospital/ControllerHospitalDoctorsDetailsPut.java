package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalDoctorsDetails;
import com.puggysoft.services.hospital.ServiceHospitalDoctorsDetailsEditById;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalDoctorsDetailsPut {

  @Autowired
  private ServiceHospitalDoctorsDetailsEditById serviceHospitalDoctorsDetailsEditById;

  @PutMapping(path = "/api/v1/hospital-doctors-details/{id}")
  public ResponseEntity<String> put(@PathVariable Long id,
      @RequestBody @Valid DtoHospitalDoctorsDetails dtoHospitalDoctorsDetails) {
    return serviceHospitalDoctorsDetailsEditById.editById(id, dtoHospitalDoctorsDetails);
  }
}
