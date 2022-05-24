package com.nava.springdatajpaimplementation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity  // it specifies that this class is a table in DB
@Data    // since we should have getters and setters, but instead of writing getters and setters, we are using Lambok to remove boiler code
@AllArgsConstructor
@NoArgsConstructor
@Builder   //  to add the builder pattern for entity class

@Table(
        name="tbl_student", uniqueConstraints = @UniqueConstraint(name="emailId_unique", columnNames = "email_address")
)
public class Student {

   @Id
   @SequenceGenerator(              // sequence generator
           name="student_sequence",
           sequenceName = "student_sequence",
           allocationSize = 1
   )
   @GeneratedValue(                                // values to be generated in sequence
           strategy = GenerationType.SEQUENCE,
           generator = "student_sequence"
   )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(name="email_address", nullable = false)  // nullable : every time we should be getting emailId otherwise it throws exception
    private String emailId;

    @Embedded
    private Guardian guardian;





}
