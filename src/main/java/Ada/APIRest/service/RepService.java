package Ada.APIRest.service;

import Ada.APIRest.DTO.StudentDTO;
import Ada.APIRest.entity.Rep;

import Ada.APIRest.entity.Student;
import Ada.APIRest.enums.UserRole;
import Ada.APIRest.repository.RepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepService {
    @Autowired
    RepRepository repRepo;

    public Iterable<Rep> findAll() {
        return this.repRepo.findAll();
    }

    public Optional<Rep> findById(long repId) {
        return this.repRepo.findById(repId);
    }

    public Rep save(@org.jetbrains.annotations.NotNull Rep rep) {
        rep.setUserRole(UserRole.Rep);
        return this.repRepo.save(rep);
    }
}


