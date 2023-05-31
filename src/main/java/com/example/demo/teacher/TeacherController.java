package com.example.demo.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TeacherInfo;

@RestController
@RequestMapping(path = "api/v1/teacher")
public class TeacherController {

  private final TeacherService teacherService;

  @Autowired
  public TeacherController(TeacherService teacherService) {
    this.teacherService = teacherService;
  }

  @GetMapping
  public List<TeacherInfo> getTeachers() {
    return teacherService.getTeachers();
  }

  @PostMapping
  public void registerNewTeacher(@RequestBody Teacher teacher) {
    teacherService.addNewTeacher(teacher);
  }

  @DeleteMapping(path = "{teacherId}")
  public void deleteTeacher(@PathVariable("teacherId") Long teacherId) {
    teacherService.deleteTeacher(teacherId);
  }

  @PutMapping(path = "{teacherId}")
  public void updateTeacher(
      @PathVariable("teacherId") Long teacherId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String email) {
    teacherService.updateTeacher(teacherId, name, email);
  }
}
