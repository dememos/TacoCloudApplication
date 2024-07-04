package ch.dememos.tacocloudapplication.model;

import ch.dememos.tacocloudapplication.data.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class Taco {
    private String name;
    private List<Ingredient> ingredients;
}
