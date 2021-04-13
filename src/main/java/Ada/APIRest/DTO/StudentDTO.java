package Ada.APIRest.DTO;

import Ada.APIRest.entity.Address;
import Ada.APIRest.enums.Gender;
import Ada.APIRest.enums.IdType;
import Ada.APIRest.enums.UserRole;

import javax.persistence.*;
import java.util.Date;

public class StudentDTO {

    public Long id;
    public String userName;
    public String password;
    public UserRole userRole;
    public String name;
    public String lastName;
    public String email;
    public IdType docType;
    public String docNum;
    public Date birthday;
    public Gender gender;
    public Address address;
    public boolean isStudying;
}
