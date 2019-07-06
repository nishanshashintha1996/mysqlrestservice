package pizzaloop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface PizzaRepository extends CrudRepository<PizzaDetails, Integer>{

    List<PizzaDetails> findByPizzaId(Integer id);

    /*@Query(value="SELECT price,image FROM pizza_details")
    PizzaDetails findByPizzaId();*/

    //List<PizzaDetails> deleteByPizzaId(Integer id);

}
