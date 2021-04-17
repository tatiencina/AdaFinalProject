package Ada.APIRest.service;

import Ada.APIRest.DTO.OrganizationDTO;
import Ada.APIRest.DTO.RepDTO;
import Ada.APIRest.entity.Organization;
import Ada.APIRest.entity.Rep;

import Ada.APIRest.enums.UserRole;
import Ada.APIRest.repository.RepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RepService {
    @Autowired
    RepRepository repRepo;
    @Autowired
    OrganizationService orgService;
    @Autowired
    UserService userService;
    public List<RepDTO> findAll() {
        Iterable<Rep> repList = repRepo.findAll();
        List<RepDTO> repDTOList = new ArrayList<RepDTO>();
        for (Rep rep : repList
             ) {
            Organization org = rep.getOrganization();
            OrganizationDTO orgDto;
            if (org!= null) {
                 orgDto = new OrganizationDTO(rep.getOrganization());
                 rep.setOrgId(org.getId());
            } else {
                 orgDto = new OrganizationDTO();
            }

            RepDTO repItem = new RepDTO(rep, orgDto);
            repDTOList.add(repItem);
        }

        return repDTOList;
    }

    public RepDTO findById(long repId) {
        Optional<Rep> repOpt = repRepo.findById(repId);
        if (repOpt.isPresent()) {
            long orgID = repOpt.get().getOrgId();
            Optional<Organization> orgOpt = orgService.findById(orgID);
            //   org.ifPresent(organization -> repOpt.get().setOrganization(organization));
            if (orgOpt.isPresent()) {
                /*Organization organization = orgOpt.get();
                OrganizationDTO orgDto = new OrganizationDTO(organization.getName(), organization.getId(), organization.getStatus());
               */
                OrganizationDTO orgDto = new OrganizationDTO((orgOpt.get()));
                return new RepDTO(repOpt.get(), orgDto);
            } else{
                OrganizationDTO orgDto = new OrganizationDTO();
                return new RepDTO(repOpt.get(), orgDto);
            }
            }
            return null;
    }

    public Rep save(Rep rep) {
      //  rep.setRoles(UserRole.Rep); // seteo el rol
       // creo una nueva organization con el nombre que trae el json de rep
       Organization newOrg = orgService.save(new Organization (rep.organization.getName()));
       // guardo la nueva org (falta validar que no exista)
       rep.setOrganization(newOrg);
       rep.setOrgId(newOrg.getId());
        // save organization
        // setearle el id de la organization al rep
        return this.repRepo.save(rep);
    }
}



