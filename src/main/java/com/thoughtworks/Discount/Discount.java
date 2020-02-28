package com.thoughtworks.Discount;

import java.util.Map;

public class Discount {
    private Map<String, Integer> discountItem;
    private int discountMoney;

    public Discount(Map<String, Integer> discountItem) {
        this.discountItem = discountItem;
    }

    public  String getDiscountInfo() {
        return null;
    }

    public int getDiscountMoney() {
        return discountMoney;
    }
}
