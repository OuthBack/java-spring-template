package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import com.example.demo.student.StudentService;
import com.example.demo.teacher.Teacher;

@SpringBootTest
class StudentServiceTests {
  final Student student = new Student( "Mariam",
      "mariam.jamal@gmail.com",
      LocalDateTime.of(LocalDate.of(2000, Month.JANUARY, 5), LocalTime.of(0, 0, 0)),
      List.of(new Teacher("Adriel")));

  @InjectMocks
  private StudentService studentService;

  @Mock
  private StudentRepository studentRepository;

  @BeforeEach
  void setUp() {
  }

  @Nested
  class FindAllStudentTest {
    @Test
    void shouldReturnStudent() {
      when(studentRepository.findAll())
        .thenReturn(List.of(student));

      var actual = studentService.getStudents().get(0);
      assertEquals(student, actual);
    }

  }

  @Nested
  class CreateStudent {
    @Test
    void shouldReturnStudent() {
      when(studentRepository.findOptionalByEmail(student.getEmail())).thenReturn(Optional.empty());
      when(studentRepository.save(student)).thenReturn(student);
        
      var actual = studentService.addNewStudent(student);
      assertEquals(student, actual); 
    }
  }

}
