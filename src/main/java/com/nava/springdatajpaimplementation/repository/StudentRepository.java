package com.nava.springdatajpaimplementation.repository;

import com.nava.springdatajpaimplementation.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository // spring will understand that created interface is a repository interface
public interface StudentRepository extends JpaRepository <Student,Long> {

    public List<Student> findByFirstName(String firstName); // custom method declartion

    public List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
     public  Student findByFirstNameAndLastName(String firstName, String lastName);

     @Query("select s from Student s where s.emailId = ?1")  // JPQL, it is based on class name
     public Student getStudentByEmailAddress(String emailId);   // this method returns the Student object

    @Query("select s from Student s where s.emailId = ?1")  // JPQL, it is based on class name
    public String getStudentFirstNameByEmailAddress(String emailId);

     @Query(value = "select*from tbl_student  where email_address =?1 ", nativeQuery = true)  // Providing Native Query use Native Queries when dealing with complex queries
      Student getStudentByEmailAddressNative(String emailId);

    @Query(value = "select*from tbl_student  where email_address = :emailId ", nativeQuery = true)  // Native Named Param
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    // above all methods are fetching methods, let's see the modifying methods in DB

   @Modifying
   @Transactional
    @Query(value ="update  tbl_student set first_name = ?1 where email_address =?2",nativeQuery = true)
    void updateFirstNameByEmailAddress(String firstName, String emailId);


}
