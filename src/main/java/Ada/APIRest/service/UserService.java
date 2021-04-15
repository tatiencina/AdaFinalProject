package Ada.APIRest.service;

import Ada.APIRest.entity.Rep;
import Ada.APIRest.entity.Student;
import Ada.APIRest.entity.User;
import Ada.APIRest.enums.UserRole;
import Ada.APIRest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public Iterable<User> findAll() {
        return this.userRepo.findAll();
    }

    public Optional<User> findById(long userId) {
        return this.userRepo.findById(userId);
    }

    public User save(@org.jetbrains.annotations.NotNull User user) {
        user.setUserRole(UserRole.Admin);
        return this.userRepo.save(user);
    }

}
