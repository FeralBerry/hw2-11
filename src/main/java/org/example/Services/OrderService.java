package org.example.Services;

import org.example.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final Cart cart;
    public OrderService(Cart cart){
        this.cart = cart;
    }
    public List<Integer> add(List<Integer> ids){
        return cart.addItems(ids);
    }
    public List<Integer> get(){
        return cart.getItems();
    }
}
