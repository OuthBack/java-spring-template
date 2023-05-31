package com.example.demo.teacher;

import static java.lang.String.format;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TeacherInfo;

@Service
public class TeacherService {
  private final TeacherRepository teacherRepository;

  public TeacherService(TeacherRepository teacherRepository) {
    this.teacherRepository = teacherRepository;
  }

  public List<TeacherInfo> getTeachers() {
    return teacherRepository.findAll().stream().map(TeacherInfo::new).toList();
  }

  public void addNewTeacher(Teacher teacher) {
    var teacherOptional = teacherRepository.findOptionalByEmail(teacher.getEmail());

    if (teacherOptional.isPresent()) {
      throw new IllegalStateException("email taken");
    }

    teacherRepository.save(teacher);
  }

  public void deleteTeacher(Long teacherId) {
    boolean exists = teacherRepository.existsById(teacherId);

    if (!exists) {
      throw new IllegalStateException("teacher with id " + teacherId + " does not exists");
    }

    teacherRepository.deleteById(teacherId);
  }

  public void updateTeacher(Long teacherId, String name, String email) {
    Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new IllegalStateException(
        format("teacher with id %s does not exists", teacherId)));

    if (name != null && name.length() > 0 && !Objects.equals(teacher.getName(), name)) {
      teacher.setName(name);
    }

    if (email != null && email.length() > 0 && !Objects.equals(teacher.getName(), teacher)) {
      teacher.setEmail(email);
    }

    teacherRepository.save(teacher);
  }
}
