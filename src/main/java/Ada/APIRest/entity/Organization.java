package Ada.APIRest.entity;

import Ada.APIRest.enums.OrganizationStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column (name = "name")
    private String name;
    private OrganizationStatus status;
    @OneToMany(mappedBy="organization")
    private List<Rep> repList;


    public Organization(){
    }

    public Organization(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Organization(String organizationName) {
        this.name = organizationName;

    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Rep> getRepList() {
        return repList;
    }

    public void setRepList(List<Rep> repList) {
        this.repList = repList;
    }
    public OrganizationStatus getStatus() {
        return status;
    }
    public void setStatus(OrganizationStatus status) {
        this.status = status;
    }
}
