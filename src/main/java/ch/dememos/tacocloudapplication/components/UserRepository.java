package ch.dememos.tacocloudapplication.components;

import ch.dememos.tacocloudapplication.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
