package com.lms.app.models;

import com.lms.app.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
    private String studentName;
    private String studentId;
    private Integer courseId;
    private Integer enrollmentId;

    public StudentResponseDto(Student student) {
        this.courseId=student.getCourseId();
        this.studentName=student.getStudentName();
        this.studentId=student.getStudentId();
        this.enrollmentId=student.getEnrollmentId();
    }
}
