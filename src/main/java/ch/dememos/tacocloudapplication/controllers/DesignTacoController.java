package ch.dememos.tacocloudapplication.controllers;

import ch.dememos.tacocloudapplication.data.Ingredient;
import ch.dememos.tacocloudapplication.model.Taco;
import ch.dememos.tacocloudapplication.model.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GBFT", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("IUOL", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("JKIU", "Diced Tomates", Ingredient.Type.VEGGIES),
                new Ingredient("HDJS", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("LOSD", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("KSDJ", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("JSHA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("XSDV", "Sour Cream", Ingredient.Type.SAUCE)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }
}
