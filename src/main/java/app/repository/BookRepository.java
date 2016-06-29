package app.repository;

import app.model.User;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<User, Long> {

}
