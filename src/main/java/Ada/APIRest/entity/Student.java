package Ada.APIRest.entity;

import Ada.APIRest.DTO.StudentDTO;
import Ada.APIRest.enums.Gender;
import Ada.APIRest.enums.IdType;
import Ada.APIRest.enums.UserRole;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity(name="Student")
@DiscriminatorValue(value="Student")
public class Student extends User{
    @NotNull
    private Date birthday;
    private Gender gender;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    private boolean isStudying;

    public Student(String userName, String password, UserRole userRole, String name, String lastName, String email, IdType docType, String docNum) {
        super(userName, password, userRole, name, lastName, email, docType, docNum);
    }

    public Student() {
        super();
    }

    public Student(StudentDTO studentDTO) {
        super(studentDTO.userName, studentDTO.password, studentDTO.userRole, studentDTO.name, studentDTO.lastName, studentDTO.email, studentDTO.docType, studentDTO.docNum) ;
        this.birthday = studentDTO.birthday;
        this.gender = studentDTO.gender;
        this.address = studentDTO.address;
        this.isStudying = studentDTO.isStudying;
        //this.id = 1L;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isStudying() {
        return isStudying;
    }

    public void setStudying(boolean studying) {
        isStudying = studying;
    }
}
