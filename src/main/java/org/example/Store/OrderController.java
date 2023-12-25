package org.example.Store;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.Services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/store/order/")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }
    @GetMapping("/add")
    public List<Integer> add(HttpServletRequest request, @RequestParam (value = "id") int id){
        HttpSession session = request.getSession();
        // Store data in the session
        if(session.getAttribute("username") == null){
            session.setAttribute("username", RandomGenerate());
        }
        return orderService.add(id, (String) session.getAttribute("username"));
    }
    @GetMapping("/get")
    public String get(HttpServletRequest request){
        HttpSession session = request.getSession();
        return orderService.get((String) session.getAttribute("username"));
    }
    private String RandomGenerate(){
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        return new Random().ints(50, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
