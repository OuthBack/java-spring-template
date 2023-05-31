package com.example.demo.student;

import static java.lang.String.format;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public void addNewStudent(Student student) {
    var studentOptional = studentRepository.findOptionalByEmail(student.getEmail());

    if (studentOptional.isPresent()) {
      throw new IllegalStateException("email taken");
    }

    studentRepository.save(student);
  }

  public void deleteStudent(Long studentId) {
    boolean exists = studentRepository.existsById(studentId);

    if (!exists) {
      throw new IllegalStateException("student with id " + studentId + " does not exists");
    }

    studentRepository.deleteById(studentId);
  }

  public void updateStudent(Long studentId, String name, String email) {
    Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
        format("student with id %s does not exists", studentId)));

    if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
      student.setName(name);
    }

    if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
      var studentOptional = studentRepository.findOptionalByEmail(email);

      if (studentOptional.isPresent()) {
        throw new IllegalStateException("email taken");
      }

      student.setEmail(email);
    }

    studentRepository.save(student);
  }
}
