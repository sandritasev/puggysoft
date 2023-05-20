package com.puggysoft.services.hospital;

import com.puggysoft.dtos.hospital.DtoHospitalPatientsHistoryA;
import com.puggysoft.dtos.hospital.DtoHospitalPatientsHistoryAFilter;
import com.puggysoft.entities.hospital.EntityHospitalPatientsHistoryA;
import com.puggysoft.repositories.hospital.IRepositoryHospitalPatientsHistoryA;
import com.puggysoft.tools.hospital.SqlHospitalPatientsHistoryAFilterBuilderNative;
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
public class ServiceHospitalPatientsHistoryAGetFilter {

  @Autowired
  private IRepositoryHospitalPatientsHistoryA repositoryHospitalPatientsHistoryA;

  @PersistenceContext
  private EntityManager entityManager;

  /** method for filter. */
  @SuppressWarnings(value = "unchecked")

  public ResponseEntity<List<DtoHospitalPatientsHistoryA>> filter(
      DtoHospitalPatientsHistoryAFilter dtoHospitalPatientsHistoryAFilter, int page, int size) {

    String query = SqlHospitalPatientsHistoryAFilterBuilderNative.build(dtoHospitalPatientsHistoryAFilter);
    int off = page * size;
    List<EntityHospitalPatientsHistoryA> listEntities;
    if (query.equals("")) {
      listEntities = repositoryHospitalPatientsHistoryA.findHospitalPatientsHistoryAByPagination(off, size);
    } else {
      // Delete last 'AND' key workd.
      query = query.substring(0, query.length() - 4);
      String fullQuery = "SELECT hospital_patients_history_a.* FROM hospital_patients_history_a WHERE "
          + query + " LIMIT " + off + "," + size;
      // JQPL (createQuery) and Native (createNativeQuery)
      Query filterQuery = entityManager.createNativeQuery(fullQuery, EntityHospitalPatientsHistoryA.class);
      listEntities = (List<EntityHospitalPatientsHistoryA>) filterQuery.getResultList();
    }
    List<DtoHospitalPatientsHistoryA> listDtoHospitalPatientsHistoryA = listEntities
        .stream()
        .map(DtoHospitalPatientsHistoryA::entityToDto)
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoHospitalPatientsHistoryA);
  }

}
