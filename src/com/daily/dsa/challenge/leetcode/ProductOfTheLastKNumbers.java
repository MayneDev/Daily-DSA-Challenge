package src.com.daily.dsa.challenge.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers {
    private final List<Integer> products;

    public ProductOfTheLastKNumbers() {
        products = new ArrayList<>();
    }

    public void add(int num) {
        int size = products.size();
        if (num == 0) {
            products.clear();
        } else {
            products.add((size > 0 ? products.get(size - 1) : 1) * num);
        }
    }

    public int getProduct(int k) {
        int size = products.size();
        int idx = size - k;
        if (idx > 0) return products.get(size - 1) / products.get(idx - 1);
        if (idx == 0) return products.get(size - 1);
        return 0;
    }
}
