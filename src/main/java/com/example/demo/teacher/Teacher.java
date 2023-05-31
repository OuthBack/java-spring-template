package com.example.demo.teacher;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.SEQUENCE;

import java.util.List;

import com.example.demo.student.Student;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Teacher {
  @Id
  @GeneratedValue(strategy = SEQUENCE)
  private Long id;

  private String name;
  private String email;

  @ManyToMany(cascade = ALL, mappedBy = "teachers")
  private List<Student> students;

  public Teacher() {

  }

  public Teacher(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Student> getStudents() {
    return this.students;
  }

  public void addStudent(Student student) {
    this.students.add(student);
  }

  public void removeStudent(Student student) {
    this.students.remove(student);
  }

  public void setStudent(List<Student> student) {
    this.students = student;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", name='" + getName() + "'" +
        ", student='" + getStudents() + "'" +
        "}";
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

}
