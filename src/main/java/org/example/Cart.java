package org.example;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class Cart {
    private final List<Integer> items;

    public Cart() {
        this.items = new ArrayList<>();
    }
    public List<Integer> addItems(List<Integer> idList) {
        items.addAll(idList);
        return items;
    }
    public List<Integer> getItems(){
        return items;
    }
}
