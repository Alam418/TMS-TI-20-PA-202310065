package com.ibik.api.microservice.program_study;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibik.api.microservice.dto.ResponseData;

import java.util.List;

@RestController
@RequestMapping("/api/program_study")
public class Program_studyController {

  // @GetMapping
  // public String helloWorld(){
  // return "<h1>Hello World</h1>";
  // }

  @Autowired
  private Program_studyServices program_studyServices;

  @PostMapping
  // public Program_study postPrograms(@Valid @RequestBody Program_study programs,
  // Errors errors){
  public ResponseEntity<ResponseData<Program_study>> postPrograms(@Valid @RequestBody Program_study program_study,Errors errors) {
    ResponseData<Program_study> responseData = new ResponseData<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessage().add(error.getDefaultMessage());
      }

      responseData.setResult(false);
      responseData.setData(null);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    responseData.setResult(true);
    List<Program_study> value = new ArrayList<>();
    value.add(program_studyServices.save(program_study));
    responseData.setData(value);
    return ResponseEntity.ok(responseData);

    // return studentsServices.save(programs);
  }

  @GetMapping
  public ResponseEntity<ResponseData<Program_study>> fetchPrograms() {
    ResponseData<Program_study> responseData = new ResponseData<>();

    try {
      responseData.setResult(true);
      responseData.setMessage(null);
      List<Program_study> value = (List<Program_study>) program_studyServices.findAll();
      responseData.setData(value);

      return ResponseEntity.ok(responseData);

    } catch (Exception e) {
      responseData.setResult(false);
      responseData.getMessage().add(e.getMessage());

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

    }
    // return studentsServices.findAll();
  }

  @GetMapping("/{id}")
  // public Program_study fetchProgramsById(@PathVariable("id") int id) {
  public ResponseEntity<ResponseData<Program_study>> postPrograms(@Valid @PathVariable("id") int id,
      Program_study program_study,
      Errors errors) {
    ResponseData<Program_study> responseData = new ResponseData<>();

    try {
      responseData.setResult(true);
      List<Program_study> value = new ArrayList<>();
      value.add(program_studyServices.findOne(id));

      responseData.setData(value);

      return ResponseEntity.ok(responseData);
    } catch (Exception e) {
      responseData.setResult(false);
      responseData.getMessage().add(e.getMessage());

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

    }
    // return program_studyServices.findOne(id);
  }

  @PutMapping
  public ResponseEntity<ResponseData<Program_study>> updatePrograms(@Valid @RequestBody Program_study program_study,
      Errors errors) {
    ResponseData<Program_study> responseData = new ResponseData<>();

    if (program_study.getId() != 0) {

      if (errors.hasErrors()) {
        for (ObjectError error : errors.getAllErrors()) {
          responseData.getMessage().add(error.getDefaultMessage());
        }
        responseData.setResult(false);
        responseData.setData(null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
      }

      responseData.setResult(true);
      List<Program_study> value = new ArrayList<>();
      value.add(program_studyServices.save(program_study));
      responseData.setData(value);
      return ResponseEntity.ok(responseData);

    } else {
      responseData.setResult(false);
      responseData.setData(null);
      List<String> message = new ArrayList<>();
      message.add("ID is required");
      responseData.setMessage(message);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    // return program_studyServices.save(programs);
  }

  @DeleteMapping("/{id}")
  // public void deleteProgramsById(@PathVariable("id") int id) {
  public ResponseEntity<ResponseData<Program_study>> deleteStudentsById(@PathVariable("id") int id) {
    ResponseData<Program_study> responseData = new ResponseData<>();

    if (id != 0) {
      try {
        program_studyServices.removeOne(id);
        responseData.setResult(true);
        responseData.getMessage().add("Successfully Removed");

        return ResponseEntity.ok(responseData);

      } catch (Exception e) {
        responseData.setResult(false);
        responseData.getMessage().add(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

      }

    } else {
      List<String> message = new ArrayList<>();
      message.add("ID is required");
      responseData.setMessage(message);
      responseData.setData(null);
      responseData.setResult(false);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }
    // program_studyServices.removeOne(id);
  }

}
