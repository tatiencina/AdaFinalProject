package Ada.APIRest.repository;

import java.util.Optional;

import Ada.APIRest.entity.Role;
import Ada.APIRest.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);
}
