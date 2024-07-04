package ch.dememos.tacocloudapplication.components;

import ch.dememos.tacocloudapplication.data.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO",
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
        ingredientMap.put("COTO",
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
        ingredientMap.put("GBFT",
                new Ingredient("GBFT", "Ground Beef", Ingredient.Type.PROTEIN));
        ingredientMap.put("IUOL",
                new Ingredient("IUOL", "Carnitas", Ingredient.Type.PROTEIN));
        ingredientMap.put("JKIU",
                new Ingredient("JKIU", "Diced Tomates", Ingredient.Type.VEGGIES));
        ingredientMap.put("HDJS",
                new Ingredient("HDJS", "Lettuce", Ingredient.Type.VEGGIES));
        ingredientMap.put("LOSD",
                new Ingredient("LOSD", "Cheddar", Ingredient.Type.CHEESE));
        ingredientMap.put("KSDJ",
                new Ingredient("KSDJ", "Monterrey Jack", Ingredient.Type.CHEESE));
        ingredientMap.put("JSHA",
                new Ingredient("JSHA", "Salsa", Ingredient.Type.SAUCE));
        ingredientMap.put("XSDV",
                new Ingredient("XSDV", "Sour Cream", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
