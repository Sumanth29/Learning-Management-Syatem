package com.lms.app.models;

import com.lms.app.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Integer courseId;
    private String title;
    private Float fees;
    private String description;
    private LocalDate date;
    private String trainerName;

    public CourseDto(Course c) {
        this.courseId=c.getCourseId();
        this.title=c.getTitle();
        this.fees=c.getFees();
        this.description=c.getDescription();
        this.date=c.getDate();
        this.trainerName=c.getTrainerName();
    }
}
