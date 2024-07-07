package ch.dememos.tacocloudapplication.components;

import ch.dememos.tacocloudapplication.model.Ingredient;

import java.util.Optional;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
