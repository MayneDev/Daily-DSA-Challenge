package src.com.daily.dsa.challenge.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class StockRecord {
    int timestamp;
    int price;

    public StockRecord() {
    }

    public StockRecord(int timestamp, int price) {
        this.timestamp = timestamp;
        this.price = price;

    }
}

public class StockPrice {
    private Map<Integer, Integer> prices;
    private PriorityQueue<StockRecord> minPrice;
    private PriorityQueue<StockRecord> maxPrice;
    private int maxTimestamp = 0;

    public StockPrice() {
        this.prices = new HashMap<>();
        minPrice = new PriorityQueue<>(Comparator.comparingInt(value -> value.price));
        maxPrice = new PriorityQueue<>((a, b) -> (b.price - a.price));
        maxTimestamp = 0;
    }

    public void update(int timestamp, int price) {
        prices.put(timestamp, price);
        maxTimestamp = Math.max(maxTimestamp, timestamp);

        StockRecord stockRecord = new StockRecord(timestamp,price);
        minPrice.offer(stockRecord);
        maxPrice.offer(stockRecord);
    }

    public int current() {
        return prices.get(maxTimestamp);
    }

    public int maximum() {
        StockRecord sp = maxPrice.peek();
        while(true) {
            sp = maxPrice.peek();
            if(sp.price != prices.get(sp.timestamp))
                maxPrice.poll();
            else break;
        }
        return sp.price;
    }

    public int minimum() {
        StockRecord sp = minPrice.peek();
        while(true) {
            sp = minPrice.peek();
            if(sp.price != prices.get(sp.timestamp))
                minPrice.poll();
            else break;
        }
        return sp.price;

    }
}
