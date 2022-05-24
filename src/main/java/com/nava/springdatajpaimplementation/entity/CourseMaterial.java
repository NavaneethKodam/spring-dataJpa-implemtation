package com.nava.springdatajpaimplementation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")   // mean sthat don't return course entity when it is called
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false) // optional = false, when ever you try to save a course, course material is required.
    @JoinColumn(              // simply we are specifying foreign key of course_material table from Course Table
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;  // this is mapping, course material consist of course, it means that this CourseMaterial will have an extra column of course_id
}
