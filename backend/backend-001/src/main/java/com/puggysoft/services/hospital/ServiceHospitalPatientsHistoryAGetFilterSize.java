package com.puggysoft.services.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsHistoryAFilter;
import com.puggysoft.repositories.hospital.IRepositoryHospitalPatientsHistoryA;
import com.puggysoft.support.TotalPagesCalculator;
import com.puggysoft.tools.hospital.SqlHospitalPatientsHistoryAFilterBuilderNative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for get size. */
@Service
public class ServiceHospitalPatientsHistoryAGetFilterSize {

  @Autowired
  private IRepositoryHospitalPatientsHistoryA repositoryHospitalPatientsHistoryA;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for get size. */
  public ResponseEntity<Long> getSize(DtoHospitalPatientsHistoryAFilter dtoHospitalPatientsHistoryAFilter,
      Long pageSize) {

    String query = SqlHospitalPatientsHistoryAFilterBuilderNative.build(dtoHospitalPatientsHistoryAFilter);
    Long totalRows = 0L;
    if (query.equals("")) {
      totalRows = repositoryHospitalPatientsHistoryA.findSize();
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT COUNT(*) FROM hospital_patients_history_a WHERE " + query;
      Query filterQuery = entityManager.createNativeQuery(fullQuery);
      totalRows = Long.valueOf(filterQuery.getSingleResult().toString());
    }
    Long totalPages = TotalPagesCalculator.getTotalPages(totalRows, pageSize);
    return ResponseEntity.status(HttpStatus.OK).body(totalPages);
  }

}
