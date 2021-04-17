package Ada.APIRest.entity;

import Ada.APIRest.enums.IdType;
import Ada.APIRest.enums.UserRole;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Rep")
public class Rep extends User {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    public Organization organization;

    protected Rep(String userName, String password, UserRole userRole, String name, String lastName, String email, IdType docType, String docNum, Organization organization, Long orgId) {
        super(userName, password, userRole, name, lastName, email, docType, docNum);
        this.organization = organization;
        //this.orgId = orgId;
    }

    public Rep(Organization organization) {
        this.organization = organization;
    }
    public Rep(){

    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
