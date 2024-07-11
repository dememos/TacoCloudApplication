package ch.dememos.tacocloudapplication.components;

import ch.dememos.tacocloudapplication.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<TacoOrder, String> {

}
