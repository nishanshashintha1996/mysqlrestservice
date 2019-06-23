package pizzaloop;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface PizzaRepository extends CrudRepository<PizzaDetails, Integer>{

    List<PizzaDetails> findByPizzaId(Integer id);

    //List<PizzaDetails> deleteByPizzaId(Integer id);

}
