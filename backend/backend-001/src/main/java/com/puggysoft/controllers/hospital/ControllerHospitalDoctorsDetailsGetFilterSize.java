package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalDoctorsDetailsFilter;
import com.puggysoft.services.hospital.ServiceHospitalDoctorsDetailsGetFilterSize;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalDoctorsDetailsGetFilterSize {

  @Autowired
  private ServiceHospitalDoctorsDetailsGetFilterSize serviceHospitalDoctorsDetailsGetFilterSize;

  @PostMapping(path = "/api/v1/hospital-doctors-details/filter/size/{pageSize}")
  public ResponseEntity<Long> getSize(
      @RequestBody @Valid DtoHospitalDoctorsDetailsFilter dtoHospitalDoctorsDetailsFilter,
      @PathVariable Long pageSize) {
    return serviceHospitalDoctorsDetailsGetFilterSize.getSize(dtoHospitalDoctorsDetailsFilter,
        pageSize);
  }
}