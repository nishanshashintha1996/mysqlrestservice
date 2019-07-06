package pizzaloop;

import org.springframework.data.repository.CrudRepository;

public interface CustomerCartRepository extends CrudRepository<CustomerCartDetails, Integer> {

}
