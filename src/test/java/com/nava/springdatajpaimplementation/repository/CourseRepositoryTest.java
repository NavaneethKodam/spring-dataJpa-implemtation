package com.nava.springdatajpaimplementation.repository;

import com.nava.springdatajpaimplementation.entity.Course;
import com.nava.springdatajpaimplementation.entity.Student;
import com.nava.springdatajpaimplementation.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

  //  @Test
    public void printCourses()
    {
        List<Course> courses = courseRepository.findAll(); // no need to define this method in courseRepository interface, since it is default method
        System.out.println("courses = " +courses);


    }

  //  @Test
    public void saveCourseWithTeacher()
    {
        Teacher teacher = Teacher.builder().firstName("priyanka").lastName("kodam").build();
        Course course = Course.builder().title(".net").credit(7).teacher(teacher).build();
        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher()
    {

        Teacher teacher = Teacher.builder().firstName("Lizza").lastName("Morgan").build();

        Student student = Student.builder().firstName("Abhishek").lastName("sign").emailId("abhi@gmail.com").build();
        Course course = Course.builder().
                         title("AI")
                          .credit(12).teacher(teacher).build();
        course.addStudents(student);


        courseRepository.save(course);


    }


}