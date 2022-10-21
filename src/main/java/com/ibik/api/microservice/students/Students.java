package com.ibik.api.microservice.students;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="students")
public class Students implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(length = 15)
  @NotEmpty(message = "NPM is required")
  private String npm;

  @Column(length = 10)
  @NotEmpty(message = "Firstname is required")
  private String firstname;

  @Column(length = 10)
  private String middlename;

  @Column(length = 10)
  @NotEmpty(message = "Lastname is required")
  private String lastname;

  // @Min(value = 1, message = "Program is required")
  // private int program_id;

  // @Min(value = 1, message = "Departement is required")
  // private int departement_id;

  public Students() {
  }

  public Students(int id, @NotEmpty(message = "NPM is required") String npm,
      @NotEmpty(message = "Firstname is required") String firstname, String middlename,
      @NotEmpty(message = "Lastname is required") String lastname,
      @Min(value = 1, message = "Program is required") int program_id,
      @Min(value = 1, message = "Departement is required") int departement_id) {
    this.id = id;
    this.npm = npm;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    // this.program_id = program_id;
    // this.departement_id = departement_id;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNpm() {
    return npm;
  }

  public void setNpm(String npm) {
    this.npm = npm;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public void setMiddlename(String middlename) {
    this.middlename = middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  // public int getProgram_id() {
  //   return program_id;
  // }

  // public void setProgram_id(int program_id) {
  //   this.program_id = program_id;
  // }

  // public int getDepartement_id() {
  //   return departement_id;
  // }

  // public void setDepartement_id(int departement_id) {
  //   this.departement_id = departement_id;
  // }
  
}
