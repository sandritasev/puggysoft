package com.puggysoft.services.alcaldia;

import com.puggysoft.dtos.alcaldia.DtoUrbanismoEstados;
import com.puggysoft.repositories.alcaldia.IRepositoryUrbanismoEstados;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/** Services for get all data. */
@Service
public class ServiceUrbanismoEstadosGetAll {

  @Autowired
  private IRepositoryUrbanismoEstados repository;

  /** method for retrive. */
  public ResponseEntity<List<DtoUrbanismoEstados>> getAll() {
    List<DtoUrbanismoEstados> listDtoRole = repository.findAll()
            .stream()
            .map(DtoUrbanismoEstados::entityToDto)
            .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(listDtoRole);
  }
}