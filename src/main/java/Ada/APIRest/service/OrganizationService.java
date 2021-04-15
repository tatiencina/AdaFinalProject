package Ada.APIRest.service;

import Ada.APIRest.entity.Organization;
import Ada.APIRest.enums.OrganizationStatus;
import Ada.APIRest.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository orgRepo;

public Organization save (Organization organization){
    organization.setStatus(OrganizationStatus.PendingApproval);
    return this.orgRepo.save((organization));
}

public Optional <Organization> findById (long orgId){
    return this.orgRepo.findById(orgId);


}
}
