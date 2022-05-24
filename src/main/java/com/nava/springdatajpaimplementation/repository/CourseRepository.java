package com.nava.springdatajpaimplementation.repository;

import com.nava.springdatajpaimplementation.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
