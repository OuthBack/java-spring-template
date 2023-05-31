package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.student.Student;
import com.example.demo.teacher.Teacher;

public class TeacherInfo {
  private final Long id;
  private final String name;
  private final String email;
  private final List<StudentInfo> students;

  public TeacherInfo(Teacher teacher) {
    this.id = teacher.getId();
    this.name = teacher.getName();
    this.email = teacher.getEmail();
    this.students = teacher.getStudents().stream().map(StudentInfo::new).toList();
  }

  class StudentInfo {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime dob;
    private Integer age;

    public StudentInfo(Student student) {
      this.id = student.getId();
      this.name = student.getName();
      this.email = student.getEmail();
      this.dob = student.getDob();
      this.age = student.getAge();
    }

    public Long getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public String getEmail() {
      return email;
    }

    public LocalDateTime getDob() {
      return dob;
    }

    public Integer getAge() {
      return age;
    }

  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<StudentInfo> getStudents() {
    return students;
  }

  public String getEmail() {
    return email;
  }

}