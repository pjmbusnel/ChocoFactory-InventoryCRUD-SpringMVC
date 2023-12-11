package com.pjmb.hiberspring.students;

import com.pjmb.hiberspring.students.pojo.StudentPOJO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<StudentPOJO> getStudents() {

        List<StudentPOJO> theEmployees = new ArrayList<>();
        theEmployees.add(new StudentPOJO("Lisa", "Mona", "Mona@louvre.fr"));
        theEmployees.add(new StudentPOJO("Mario", "Bros", "Mario@nintendo.co.jp"));
        theEmployees.add(new StudentPOJO("Luigi", "Bros", "Luigi@nintendo.co.jp"));

        return theEmployees;
    }

    @GetMapping("/students/{studentId}")
    public StudentPOJO getStudent(@PathVariable int studentId) {

        List<StudentPOJO> theEmployees = new ArrayList<>();
        theEmployees.add(new StudentPOJO("Lisa", "Mona", "Mona@louvre.fr"));
        theEmployees.add(new StudentPOJO("Mario", "Bros", "Mario@nintendo.co.jp"));
        theEmployees.add(new StudentPOJO("Luigi", "Bros", "Luigi@nintendo.co.jp"));

        if (studentId < 0 || studentId > theEmployees.size())
            throw new StudentNotFoundException("Student id not found - " + studentId);

        return theEmployees.get(studentId);
    }

    /*@ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
        // Too specific because of StudentNotFoundException parameter
      StudentErrorResponse error = new StudentErrorResponse();
      error.setStatus(HttpStatus.NOT_FOUND.value());
      error.setMessage(e.getMessage());
      error.setTimestamp(System.currentTimeMillis());

      return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }*/

    /*@ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
        System.out.println("handleException in StudentRestController");
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }*/
}
