package com.ibik.api.microservice.students;

import org.springframework.data.repository.CrudRepository;

public interface StudentsRepo extends CrudRepository<Students, Integer>{
  
}