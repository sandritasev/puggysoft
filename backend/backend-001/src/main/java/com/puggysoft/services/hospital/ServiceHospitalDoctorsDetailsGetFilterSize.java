package com.puggysoft.services.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalDoctorsDetailsFilter;
import com.puggysoft.repositories.hospital.IRepositoryHospitalDoctorsDetails;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.hospital.SqlHospitalDoctorsDetailsFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceHospitalDoctorsDetailsGetFilterSize {

  @Autowired
  private IRepositoryHospitalDoctorsDetails repositoryHospitalDoctorsDetails;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoHospitalDoctorsDetailsFilter dtoHospitalDoctorsDetailsFilter, Long pageSize) {

    String query = SqlHospitalDoctorsDetailsFilterBuilderNative.build(dtoHospitalDoctorsDetailsFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryHospitalDoctorsDetails.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM hospital_doctors_details WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
