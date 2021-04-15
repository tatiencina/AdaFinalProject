package Ada.APIRest.DTO;

import Ada.APIRest.entity.Organization;
import Ada.APIRest.enums.OrganizationStatus;

public class OrganizationDTO {
    public Long id;
    public String name;
    public OrganizationStatus status;

    public OrganizationDTO(String name, Long id, OrganizationStatus status) {
    }

    public OrganizationDTO(Organization organization) {
        this.id = organization.getId();
        this.name = organization.getName();
        this.status = organization.getStatus();
    }

    public OrganizationDTO() {

    }
}
