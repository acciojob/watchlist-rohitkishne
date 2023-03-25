package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student)
    {
        String add = studentService.addStudent(student);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<String> addteacher(@RequestBody Teacher teacher)
    {
        String add = studentService.addTeacher(teacher);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam("studentName") String studentName,
                                                        @RequestParam("teacherName")String teacherName)
    {
        String addPair = studentService.addStudentTeacherPair(studentName, teacherName);
        return new ResponseEntity<>(addPair, HttpStatus.CREATED);
    }

    @GetMapping("/get-student-by-name/{studentName}")
    public ResponseEntity<Student> getStudentByName(@PathVariable("studentName") String studentName)
    {
        Student name = studentService.getStudentByName(studentName);
        return new ResponseEntity<>(name, HttpStatus.CREATED);
    }

    @GetMapping("/get-teacher-by-name/{teacherName}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable("teacherName") String teacherName)
    {
        Teacher name = studentService.getTeacherByName(teacherName);
        return new ResponseEntity<>(name, HttpStatus.CREATED);
    }

    @GetMapping("/get-students-by-teacher-name/{teacherName}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable("teacherName")String teacherName)
    {
        List<String> allStudentbyTeacher = studentService.getStudentsByTeacherName(teacherName);
        return new ResponseEntity<>(allStudentbyTeacher, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents()
    {
        List<String> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam("teacherName") String teacherName)
    {
        String delete = studentService.deleteTeacherByName(teacherName);
        return new ResponseEntity<>(delete, HttpStatus.CREATED);
    }

    @DeleteMapping("/studentTeacherPairDB")
    public ResponseEntity<String> deleteAllTeachers()
    {
        String delete = studentService.deleteAllTeachers();
        return new ResponseEntity<>(delete, HttpStatus.CREATED);
    }
}
