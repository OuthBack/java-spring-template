package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.student.Student;
import com.example.demo.teacher.Teacher;

public class StudentInfo {
  private final Long id;
  private final String name;
  private final String email;
  private final LocalDateTime dob;
  private final Integer age;
  private final List<TeacherInfo> teacher;

  public StudentInfo(Student student) {
    this.id = student.getId();
    this.name = student.getName();
    this.email = student.getEmail();
    this.dob = student.getDob();
    this.age = student.getAge();

    List<TeacherInfo> newTeacher = student.getTeacher().stream().map(TeacherInfo::new).toList();
    this.teacher = newTeacher;
  }

  class TeacherInfo {
    private Long id;
    private String name;

    public TeacherInfo() {
    }

    public TeacherInfo(Teacher teacher) {
      this.id = teacher.getId();
      this.name = teacher.getName();
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

  public List<TeacherInfo> getTeacher() {
    return teacher;
  }
}
