package Ada.APIRest.entity;

import Ada.APIRest.enums.IdType;
import Ada.APIRest.enums.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;
    @Column(name = "user_name")
    protected String userName;
    @Column(name = "password")
    protected String password;
    @Column (name = "user_role")
    protected UserRole userRole;
    @Column (name = "name")
    protected String name;
    @Column (name = "last_name")
    protected String lastName;
    @Column (name = "email")
    protected String email;
    @Column (name = "doc_type")
    protected IdType docType;
    @Column (name = "doc_num")
    protected String docNum;

    protected User(String userName, String password, UserRole userRole, String name, String lastName, String email, IdType docType, String docNum) {
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.docType = docType;
        this.docNum = docNum;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IdType getDocType() {
        return docType;
    }

    public void setDocType(IdType docType) {
        this.docType = docType;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
