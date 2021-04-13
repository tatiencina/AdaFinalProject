package Ada.APIRest.entity;

import Ada.APIRest.enums.IdType;
import Ada.APIRest.enums.UserRole;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Rep")
public class Rep extends User {

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    public Organization organization;

    protected Rep(String userName, String password, UserRole userRole, String name, String lastName, String email, IdType docType, String docNum, Organization organization) {
        super(userName, password, userRole, name, lastName, email, docType, docNum);
        this.organization = organization;
    }

    public Rep(Organization organization) {
        this.organization = organization;
    }
    public Rep(){

    }

}
