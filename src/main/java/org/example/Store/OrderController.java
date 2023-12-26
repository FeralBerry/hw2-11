package org.example.Store;

import org.example.Services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store/order/")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @GetMapping("/add")
    public List<Integer> add(@RequestParam List<Integer> ids){
        return orderService.add(ids);
    }
    @GetMapping("/get")
    public List<Integer> get(){
        return orderService.get();
    }
}
