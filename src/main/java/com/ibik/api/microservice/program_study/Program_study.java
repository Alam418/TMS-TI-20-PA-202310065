package com.ibik.api.microservice.program_study;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ibik.api.microservice.programs.Programs;

@Entity
@Table(name = "program_study")
public class Program_study implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(length = 50)
  @NotEmpty(message = "Name is required")
  private String name;

  @Column(length = 20)
  private String description;

  @Column(length = 5)
  @NotEmpty(message = "Code is required")
  private String code;

  // @Min(value = 1, message = "Program is required")
  @ManyToOne
  @JoinColumn(name = "program_id")
  private Programs program_id;

  @OneToMany
  @JoinColumn(name = "faculty_id")
  private Set<Program_study> Departments;

  @Column(nullable = false, columnDefinition = "TINYINT(1)")
  private boolean is_active;

  // private int faculty_id;

  public Program_study() {
  }

  public Program_study(int id, @NotEmpty(message = "Name is required") String name, String description,
      @NotEmpty(message = "Code is required") String code, int program_id, int faculty_id, int department_id,
      boolean is_active) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.code = code;
    this.is_active = is_active;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Programs getProgram_id() {
    return program_id;
  }

  public void setProgram_id(Programs program_id) {
    this.program_id = program_id;
  }

  public boolean isIs_active() {
    return is_active;
  }

  public void setIs_active(boolean is_active) {
    this.is_active = is_active;
  }

  public Set<Program_study> getDepartments() {
    return Departments;
  }

  public void setDepartments(Set<Program_study> departments) {
    Departments = departments;
  }

  // public int getFaculty_id() {
  // return faculty_id;
  // }

  // public void setFaculty_id(int faculty_id) {
  // this.faculty_id = faculty_id;
  // }

  // @Min(value = 1, message = "Program is required")
  // private int faculty_id;

  // @Min(value = 1, message = "Departement is required")
  // private int departement_id;

  // @Column(nullable = false, columnDefinition = "TINYINT(1)")
  // private boolean is_active;

}
