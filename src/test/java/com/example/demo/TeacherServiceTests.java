package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.TeacherInfo;
import com.example.demo.teacher.Teacher;
import com.example.demo.teacher.TeacherRepository;
import com.example.demo.teacher.TeacherService;

@SpringBootTest
class TeacherServiceTests {
  final Teacher teacher = new Teacher("Adriel");

  @InjectMocks
  private TeacherService teacherService;

  @Mock
  private TeacherRepository teacherRepository;

  @BeforeEach
  void setUp() {
  }

  @Nested
  class FindAllTeachersTest {
    @Test
    void shouldReturnTeachers() {
      when(teacherRepository.findAll())
        .thenReturn(List.of(teacher));
      var actual = teacherService.getTeachers().get(0);
      System.err.println(actual);
      assertEquals(new TeacherInfo(teacher), actual);
    }

  }
}
