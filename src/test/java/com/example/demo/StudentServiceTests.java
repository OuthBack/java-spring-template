package com.example.demo;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.StudentInfo;
import com.example.demo.dto.TeacherInfo;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import com.example.demo.student.StudentService;
import com.example.demo.teacher.Teacher;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@SpringBootTest
class StudentServiceTests {
  @InjectMocks
  private StudentService studentService;

  @Mock
  private StudentRepository studentRepository;

  @Test
  void testGetStudents() {
    Student student = new Student(
      "Mariam",
      "mariam.jamal@gmail.com",
      LocalDateTime.of(LocalDate.of(2000, Month.JANUARY, 5), LocalTime.of(0, 0, 0)),
      List.of(new Teacher("Adriel")));

    when(this.studentRepository.findAll())
        .thenReturn(List.of(student));

    var actual = this.studentService.getStudents().get(0);
    assertEquals(actual, student);
    // assertThat(actual.getEmail(), is(student.getEmail()));
  }

}
