package com.example.demo.student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.teacher.Teacher;
import com.example.demo.teacher.TeacherRepository;

@Configuration
public class StudentConfig {

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository studentRepository, TeacherRepository teacherRepository) {
    return args -> {
      Teacher adriel = new Teacher("Adriel");
      Teacher marcos = new Teacher("Marcos");
      Teacher tiago = new Teacher("Tiago");
      Teacher gabriel = new Teacher("Gabriel");

      List<Teacher> teachers1 = new ArrayList<>();
      teachers1.add(adriel);
      teachers1.add(marcos);

      List<Teacher> teachers2 = new ArrayList<>();
      teachers2.add(tiago);
      teachers2.add(gabriel);

      Student mariam = new Student(
          "Mariam",
          "mariam.jamal@gmail.com",
          LocalDateTime.of(LocalDate.of(2000, Month.JANUARY, 5), LocalTime.of(0, 0, 0)),
          new ArrayList<>(teachers1));

      Student alex = new Student(
          "Alex",
          "alex@gmail.com",
          LocalDateTime.of(LocalDate.of(2004, Month.JANUARY, 5), LocalTime.of(0, 0, 0)),
          new ArrayList<>(teachers2));

      studentRepository.saveAll(List.of(mariam, alex));
    };
  }
}
