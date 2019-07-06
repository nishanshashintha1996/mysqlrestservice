package pizzaloop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface CartRepository extends CrudRepository<CartDetails, Integer> {
    List<CartDetails> findByCustomerId(Integer id);
    //List<CartDetails> findByCartId(Integer id);
    List<CartDetails> deleteByCartId(Integer id);
}
