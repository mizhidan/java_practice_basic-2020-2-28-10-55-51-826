package com.thoughtworks.Discount;

import java.util.Map;

public class NoneDiscount extends Discount implements promotion {

    private int discountPrice;
    private Map<String, Integer> discountItem;

    public NoneDiscount(Map<String, Integer> discountItem) {
        super(discountItem);
        this.discountItem = discountItem;
    }

    @Override
    public int getDiscountMoney() {
        return 0;
    }

    @Override
    public String getDiscountInfo() {
        return "";
    }
}
