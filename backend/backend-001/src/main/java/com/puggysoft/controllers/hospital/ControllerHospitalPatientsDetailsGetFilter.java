package com.puggysoft.controllers.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsDetails;
import com.puggysoft.dtos.hospital.DtoHospitalPatientsDetailsFilter;
import com.puggysoft.services.hospital.ServiceHospitalPatientsDetailsGetFilter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHospitalPatientsDetailsGetFilter {

  @Autowired
  private ServiceHospitalPatientsDetailsGetFilter serviceHospitalPatientsDetailsGetFilter;

  @PostMapping(path = "/api/v1/hospital-patients-details/filter")
  public ResponseEntity<List<DtoHospitalPatientsDetails>> getHospitalPatientsDetailsFilter(
      @RequestParam int page,
      @RequestParam int size,
      @RequestBody @Valid DtoHospitalPatientsDetailsFilter dtoHospitalPatientsDetailsFilter) {
    return serviceHospitalPatientsDetailsGetFilter.filter(dtoHospitalPatientsDetailsFilter, page, size);
  }
}