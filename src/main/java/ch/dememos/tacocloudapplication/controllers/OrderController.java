package ch.dememos.tacocloudapplication.controllers;

import ch.dememos.tacocloudapplication.model.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderForm() {
        return "order-form";
    }


    @PostMapping
    public String processOrder(TacoOrder tacoOrder, SessionStatus status) {
        log.info("Processing order {}", tacoOrder);
        status.setComplete();
        return "redirect:/";
    }
}
