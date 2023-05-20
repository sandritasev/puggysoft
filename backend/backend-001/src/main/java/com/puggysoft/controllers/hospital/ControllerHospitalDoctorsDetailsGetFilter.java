package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalDoctorsDetails;
import com.puggysoft.dtos.hospital.DtoHospitalDoctorsDetailsFilter;
import com.puggysoft.services.hospital.ServiceHospitalDoctorsDetailsGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalDoctorsDetailsGetFilter {

  @Autowired
  private ServiceHospitalDoctorsDetailsGetFilter serviceHospitalDoctorsDetailsGetFilter;

  @PostMapping(path = "/api/v1/hospital-doctors-details/filter")
  public ResponseEntity<List<DtoHospitalDoctorsDetails>> getHospitalDoctorsDetailsFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoHospitalDoctorsDetailsFilter dtoHospitalDoctorsDetailsFilter) {
    return serviceHospitalDoctorsDetailsGetFilter.filter(dtoHospitalDoctorsDetailsFilter, page, size);
  }
}
