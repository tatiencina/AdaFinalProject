package Ada.APIRest.entity;

import Ada.APIRest.enums.IdType;
import Ada.APIRest.enums.UserRole;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Rep")
public class Rep extends User {

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "organization_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Organization organization;
    @Column(name = "organization_id" )
    private Long orgId;

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }



    protected Rep(String userName, String password, String name, String lastName, String email, IdType docType, String docNum, Organization organization, Long orgId) {
        super(userName, password, name, lastName, email, docType, docNum);
        this.organization = organization;
        this.orgId = orgId;
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
