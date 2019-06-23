package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<CartDetails, Integer> {
    List<CartDetails> findByCustomerId(Integer id);
}
