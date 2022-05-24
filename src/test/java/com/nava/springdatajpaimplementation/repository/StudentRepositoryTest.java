package com.nava.springdatajpaimplementation.repository;

import com.nava.springdatajpaimplementation.entity.Guardian;
import com.nava.springdatajpaimplementation.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



@SpringBootTest  // it specifies that it is a test class, and it will affect database
//@DataJpaTest  // we can also use this, but it will not effect the database while testing
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository; // we need a studentrepository object to perform operations on student object

   // @Test
    public void saveStudent()  // method to save data in DB
    {
        Student student = Student.builder().emailId("navaneethkodam@gmail.com")
                .firstName("Navaneeth")
                .lastName("kodam").build();
                //.guardianName("Nithin")
                //.guardianEmail("k.nithin32@gmail.com")
                //.guardianMobile("8801104860").build();
            //  this a student object that has data, and data is passsed with the helpo of @Builder, no need of creating constructor explicitly

        studentRepository.save(student);
    }

    //@Test
    public void printAllStudent()   // method to print Student data from database
    {
     List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List is : " +studentList);

    }

    //@Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian = Guardian.builder().
                             email("k.nithin32@gmail.com").name("Nithin").mobile("8801104860").build();
        Student s = Student.builder().
                           firstName("Shiva").
                           emailId("shivaubergrad@gmail.com").
                           lastName("kaala").
                           guardian(guardian)
                           .build();

        studentRepository.save(s);
    }

   // @Test
    public void printStudentWithFirstName() // this is our own custom method namne
    {
        List<Student> students = studentRepository.findByFirstName("Navaneeth");
        System.out.println("students : " +students);
    }

    //@Test
    public void printStudentWithFirstNameContaining() // this is our own custom method name
    {
        List<Student> students = studentRepository.findByFirstNameContaining("Nava");
        System.out.println("students : " +students);
    }

   // @Test
    public void printStudentWithLastNameContainingNotNull() // this is our own custom method name
    {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("students : " +students);
    }

    //@Test
   public void printStudentBasedOnGuardianName() // this is our own custom method name
    {
        List<Student> students = studentRepository.findByGuardianName("Nithin");
        System.out.println("students : " +students);
    }

    //@Test
    public void printStudentBasedOnFirstAndLastName()
    {
        Student student = studentRepository.findByFirstNameAndLastName("Shiva","kaala");
        System.out.println(" student is : " + student);
    }

    @Test
    public void printGetStudentByEmailAddress()
    {
        Student student = studentRepository.getStudentByEmailAddress("navaneethkodam@gmail.com");
        System.out.println("student is  :" + student);
    }


   // @Test
    public void printGetStudentByEmailAddressNative()
    {
        Student student = studentRepository.getStudentByEmailAddressNative("shivaubergrad@gmail.com");
        System.out.println("student is : " +student );
    }

  //  @Test
    public void printStudentByEmailAddressNativeNamedParam()
    {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("shivaubergrad@gmail.com");
        System.out.println("student is : " +student );
    }

    @Test
    public void updateFirstNameByEmailAddress() {
        studentRepository.updateFirstNameByEmailAddress("Nava", "navaneethkodam@gmail.com");

    }



}