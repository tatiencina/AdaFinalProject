package Ada.APIRest.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Organizations")
public class Organization {
    public Long getId() {
        return id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column (name = "name")
    private String name;



    @OneToMany(mappedBy="organization")
    private List<Rep> repList;

    public Organization(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
