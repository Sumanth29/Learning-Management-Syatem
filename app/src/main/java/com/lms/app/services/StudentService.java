package com.lms.app.services;

import com.lms.app.entities.Course;
import com.lms.app.entities.Student;
import com.lms.app.models.CourseDto;
import com.lms.app.models.StudentRequestDto;
import com.lms.app.models.StudentResponseDto;
import com.lms.app.repositories.CourseRepository;
import com.lms.app.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<?> getCoursebyId(Integer id){
        if(courseRepository.existsById(id)) {
            Course c = courseRepository.getById(id);
            return new ResponseEntity<>(new CourseDto(c), HttpStatus.OK);
        }
        return new ResponseEntity<>("Course Not Found",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> enrollToCourse(StudentRequestDto studentDto){
        if(null !=studentDto.getCourseId() && !courseRepository.existsById(studentDto.getCourseId()))
            return new ResponseEntity<>("Invalid Course ID", HttpStatus.BAD_REQUEST);

        Course course = courseRepository.getById(studentDto.getCourseId());
        Student student = new Student();
        student.setStudentName(studentDto.getStudentName());
        student.setStudentId(studentDto.getStudentId());
        student.setCourseId(course.getCourseId());

        student = studentRepository.save(student);
        courseRepository.save(course);

        StudentResponseDto studentRequestDto= new StudentResponseDto(student);

        return new ResponseEntity<>(studentRequestDto,HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteEnrollment(Integer enrollementId){
        try{
            if(studentRepository.existsById(enrollementId)){
                studentRepository.deleteById(enrollementId);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getAllCourses() {
        List<Course> courses= courseRepository.findAll();
        List<CourseDto> coursesDtoList = new ArrayList<>();

        for(Course c: courses){
            CourseDto courseDto = new CourseDto();
            courseDto.setCourseId(c.getCourseId());
            courseDto.setDate(c.getDate());
            courseDto.setDescription(c.getDescription());
            courseDto.setFees(c.getFees());
            courseDto.setTitle(c.getTitle());
            courseDto.setTrainerName(c.getTrainerName());

            coursesDtoList.add(courseDto);
        }
        return new ResponseEntity<>(coursesDtoList,HttpStatus.OK);
    }

    public ResponseEntity getAllEnrollments() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();

        for(Student s:students){
            studentResponseDtos.add(new StudentResponseDto(s));
        }
        return new ResponseEntity<>(studentResponseDtos,HttpStatus.OK);
    }
}
