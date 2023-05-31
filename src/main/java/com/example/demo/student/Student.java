package com.example.demo.student;

import static jakarta.persistence.CascadeType.ALL;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.teacher.Teacher;

import jakarta.persistence.*;

@Entity
@Table
public class Student {
  @Id
  @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
  private Long id;
  private String name;
  private String email;
  private LocalDateTime dob;

  @ManyToMany(cascade = ALL)
  private List<Teacher> teachers = new ArrayList<>();

  @Transient
  private Integer age;

  public Student() {
  }

  public Student(
      Long id,
      String name,
      String email,
      LocalDateTime dob) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.dob = dob;
  }

  public Student(
      String name,
      String email,
      LocalDateTime dob,
      List<Teacher> teacher) {
    this.name = name;
    this.email = email;
    this.dob = dob;
    this.teachers = teacher;
    List<Student> student = new ArrayList<>();
    teacher.forEach(t -> t.setStudent(student));
  }

  public List<Teacher> getTeacher() {
    return this.teachers;
  }

  public void setTeacher(List<Teacher> teacher) {
    this.teachers = teacher;
  }

  public void addTeacher(Teacher teacher) {
    this.teachers.add(teacher);
  }

  public void removeTeacher(Teacher teacher) {
    this.teachers.add(teacher);
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getDob() {
    return this.dob;
  }

  public void setDob(LocalDateTime dob) {
    this.dob = dob;
  }

  public Integer getAge() {
    return (int) ChronoUnit.YEARS.between(this.dob, LocalDateTime.now());
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", name='" + getName() + "'" +
        ", email='" + getEmail() + "'" +
        ", dob='" + getDob() + "'" +
        ", age='" + getAge() + "'" +
        "}";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Student other = (Student) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  
}
