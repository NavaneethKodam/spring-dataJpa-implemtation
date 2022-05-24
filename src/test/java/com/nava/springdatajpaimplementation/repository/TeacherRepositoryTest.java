package com.nava.springdatajpaimplementation.repository;

import com.nava.springdatajpaimplementation.entity.Course;
import com.nava.springdatajpaimplementation.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher()
    {
        Course course = Course.builder().title("DSA").credit(5).build();
        Course courseDba = Course.builder().title("DBA").credit(6).build();
        Course courseJava = Course.builder().title("JAVA").credit(7).build();

        Teacher teacher = Teacher.builder().firstName("Ali").lastName("Khan")
                          // courses(List.of(course,courseJava,courseDba))
                           .build();
        teacherRepository.save(teacher);

    }


}