package ch.dememos.tacocloudapplication.controllers;

import ch.dememos.tacocloudapplication.components.OrderRepository;
import ch.dememos.tacocloudapplication.model.TacoOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "order-form";
    }


    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus status) {
        if (errors.hasErrors()) {
            return "order-form";
        }
        orderRepository.save(tacoOrder);
        status.setComplete();
        return "redirect:/";
    }
}
