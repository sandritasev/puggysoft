package com.puggysoft.services.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsDetails;
import com.puggysoft.dtos.hospital.DtoHospitalPatientsDetailsFilter;
import com.puggysoft.entities.hospital.EntityHospitalPatientsDetails;
import com.puggysoft.repositories.hospital.IRepositoryHospitalPatientsDetails;
import com.puggysoft.tools.hospital.SqlHospitalPatientsDetailsFilterBuilderNative;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/** Services for filter. */
@Service
public class ServiceHospitalPatientsDetailsGetFilter {

  @Autowired
  private IRepositoryHospitalPatientsDetails repositoryHospitalPatientsDetails;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoHospitalPatientsDetails>> filter(
      DtoHospitalPatientsDetailsFilter dtoHospitalPatientsDetailsFilter, int page, int size) {

    String query = SqlHospitalPatientsDetailsFilterBuilderNative.build(dtoHospitalPatientsDetailsFilter);
    int off = page * size;
    List<EntityHospitalPatientsDetails> listEntities;
    if (query.equals("")) {
      listEntities = repositoryHospitalPatientsDetails.findHospitalPatientsDetailsByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT hospital_patients_details.* FROM hospital_patients_details WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityHospitalPatientsDetails.class);
      listEntities = (List<EntityHospitalPatientsDetails>) filterQuery.getResultList();
    }
    List<DtoHospitalPatientsDetails> listDtoHospitalPatientsDetails = listEntities
        .stream()
        .map(DtoHospitalPatientsDetails::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoHospitalPatientsDetails);
  }

}
