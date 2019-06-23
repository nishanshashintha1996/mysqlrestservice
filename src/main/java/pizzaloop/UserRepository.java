package pizzaloop;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface UserRepository extends CrudRepository<UserDetails, Integer> {

    List<UserDetails> findByUserId(int id);
}
