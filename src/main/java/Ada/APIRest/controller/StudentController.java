package Ada.APIRest.controller;


import Ada.APIRest.entity.Student;
import Ada.APIRest.DTO.StudentDTO;
import Ada.APIRest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/Student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public @ResponseBody
    Iterable<Student> getAll() {
        return studentService.findAll();
    }

    @PostMapping(path = "/newStudent")
    public ResponseEntity<Student> newStudent (@RequestBody StudentDTO student) {

        Student newStudent = studentService.save(student);
        return new ResponseEntity<>(newStudent,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.findById(id);

        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}




