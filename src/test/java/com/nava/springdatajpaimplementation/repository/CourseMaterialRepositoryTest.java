package com.nava.springdatajpaimplementation.repository;

import com.nava.springdatajpaimplementation.entity.Course;
import com.nava.springdatajpaimplementation.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;


@Test
    public void saveCourseMaterial()
        {
            Course course = Course.builder().title("python").credit(6).build();  // building course object with values // backgroung builder will create constructors .....

            CourseMaterial courseMaterial = CourseMaterial.builder().url("www.telsuko.com").
                                             course(course).
                                             build();

            repository.save(courseMaterial);
        }

        //@Test
        public void printAllCourseMaterial()
        {
            List<CourseMaterial> courseMaterials = repository.findAll(); // findall() method returns all the entites saved in database
            System.out.println("courseMaterials = " +courseMaterials);
        }


}