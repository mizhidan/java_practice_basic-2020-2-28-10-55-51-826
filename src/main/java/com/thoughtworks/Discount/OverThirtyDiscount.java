package com.thoughtworks.Discount;

import java.util.Map;

public class OverThirtyDiscount extends Discount implements promotion {

    private int discountPrice;
    private Map<String, Integer> discountItem;

    public OverThirtyDiscount(Map<String, Integer> discountItem) {
        super(discountItem);
        this.discountItem = discountItem;
    }

    @Override
    public int getDiscountMoney() {
        discountPrice = 6;
        return discountPrice;
    }

    @Override
    public String getDiscountInfo() {
        StringBuilder result = new StringBuilder();
        result.append("使用优惠:\n");
        result.append("满30减6元，省6元\n");
        result.append("-----------------------------------\n");
        return result.toString();
    }
}
