package org.example.Services;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final Map<String, List<Integer>> cart = new HashMap<>();
    public List<Integer> add(int id, String sessionName){
        List<Integer> listA = new ArrayList<>();
        if(cart.get(sessionName) == null){
            listA.add(id);
        } else {
            listA = cart.get(sessionName);
            listA.add(id);
        }
        cart.put(sessionName,listA);
        return cart.get(sessionName);
    }
    public String get(String sessionName){
        return new Gson().toJson(cart.get(sessionName));
    }
}
