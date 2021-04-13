package Ada.APIRest.repository;

import Ada.APIRest.entity.Rep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepRepository extends CrudRepository <Rep, Long> {
}
