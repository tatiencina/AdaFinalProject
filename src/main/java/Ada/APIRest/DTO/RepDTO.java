package Ada.APIRest.DTO;

import Ada.APIRest.entity.Rep;
import Ada.APIRest.enums.IdType;
import Ada.APIRest.enums.UserRole;

public class RepDTO {
    public Long id;
    public String userName;
    public UserRole userRole;
    public String name;
    public String lastName;
    public String email;
    public IdType docType;
    public String docNum;
    public OrganizationDTO org;

    public RepDTO(Rep rep, OrganizationDTO orgDto) {
        this.id = rep.getId();
        this.userName = rep.getUserName();
        this.name = rep.getName();
        this.lastName = rep.getLastName();
        this.docNum = rep.getDocNum();
        this.email = rep.getEmail();
        this.userRole = rep.getUserRole();
        this.docType = rep.getDocType();
        this.org = orgDto;
    }
}
