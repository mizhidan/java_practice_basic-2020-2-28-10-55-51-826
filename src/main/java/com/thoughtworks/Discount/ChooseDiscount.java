package com.thoughtworks.Discount;

import com.thoughtworks.DataHandler.DataProvider;
import com.thoughtworks.Dish;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ChooseDiscount {
    Map<String, Integer> Dishes;

    public ChooseDiscount(Map<String, Integer> Dishes) {
        this.Dishes = Dishes;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        Iterator<Map.Entry<String, Integer>> entries = Dishes.entrySet().iterator();
        List<Dish> dishes = DataProvider.getDishes();
        while(entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            for(Dish dish : dishes) {
                    if (entry.getKey().equals(dish.getId())) {
                        totalPrice += entry.getValue() * (int)dish.getPrice();
                    }
            }
        }
        return totalPrice;
    }

    public Discount bestDiscount() {
        int totalPrice = getTotalPrice();
        int halfItemPrice = 0;
        int overThirtyPrice = 0;
        if(totalPrice >= 30) {
            HalfItemDiscount halfItem = new HalfItemDiscount(Dishes);
            OverThirtyDiscount overThirtyItem = new OverThirtyDiscount(Dishes);
            halfItemPrice = halfItem.getDiscountMoney();
            overThirtyPrice = overThirtyItem.getDiscountMoney();
            if(halfItemPrice > overThirtyPrice) {
                return halfItem;
            } else {
                return overThirtyItem;
            }
        } else {
            HalfItemDiscount halfItem = new HalfItemDiscount(Dishes);
            NoneDiscount noneDiscount = new NoneDiscount(Dishes);
            halfItemPrice = halfItem.getDiscountMoney();
            if(halfItemPrice > 0) {
                return halfItem;
            }
            return noneDiscount;
        }
    }
}
