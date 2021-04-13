package Ada.APIRest.service;

import Ada.APIRest.entity.Student;
import Ada.APIRest.DTO.StudentDTO;
import Ada.APIRest.enums.UserRole;
import Ada.APIRest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepo;

    public Iterable<Student> findAll() {
        return this.studentRepo.findAll();
    }

    public Optional<Student> findById(long studentId) {
        return this.studentRepo.findById(studentId);
    }

    public Student save(StudentDTO studentDTO) {
        Student student = new Student(studentDTO);
        //student.setAddress(studentDTO.address);
        student.setUserRole(UserRole.Student);
        return this.studentRepo.save(student);
    }

    public void deleteById(long studentId) {
        Optional<Student> student1 = studentRepo.findById(studentId);
        student1.ifPresent(student -> studentRepo.delete(student));
    }
}
