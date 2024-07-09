package ch.dememos.tacocloudapplication.components;

import ch.dememos.tacocloudapplication.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
