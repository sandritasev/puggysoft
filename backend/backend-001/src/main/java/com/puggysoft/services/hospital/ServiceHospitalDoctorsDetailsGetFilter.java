package com.puggysoft.services.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalDoctorsDetails;
import com.puggysoft.dtos.hospital.DtoHospitalDoctorsDetailsFilter;
import com.puggysoft.entities.hospital.EntityHospitalDoctorsDetails;
import com.puggysoft.repositories.hospital.IRepositoryHospitalDoctorsDetails;
import com.puggysoft.tools.hospital.SqlHospitalDoctorsDetailsFilterBuilderNative;
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
public class ServiceHospitalDoctorsDetailsGetFilter {

  @Autowired
  private IRepositoryHospitalDoctorsDetails repositoryHospitalDoctorsDetails;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoHospitalDoctorsDetails>> filter(
      DtoHospitalDoctorsDetailsFilter dtoHospitalDoctorsDetailsFilter, int page, int size) {

    String query = SqlHospitalDoctorsDetailsFilterBuilderNative.build(dtoHospitalDoctorsDetailsFilter);
    int off = page * size;
    List<EntityHospitalDoctorsDetails> listEntities;
    if (query.equals("")) {
      listEntities = repositoryHospitalDoctorsDetails.findHospitalDoctorsDetailsByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT hospital_doctors_details.* FROM hospital_doctors_details WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityHospitalDoctorsDetails.class);
      listEntities = (List<EntityHospitalDoctorsDetails>) filterQuery.getResultList();
    }
    List<DtoHospitalDoctorsDetails> listDtoHospitalDoctorsDetails = listEntities
        .stream()
        .map(DtoHospitalDoctorsDetails::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoHospitalDoctorsDetails);
  }

}