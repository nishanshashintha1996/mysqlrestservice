package pizzaloop;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotPizzaRepository extends CrudRepository<HotPizzaDetails, Integer> {
    List<PizzaDetails> findByHotPizzaId(Integer id);
}
