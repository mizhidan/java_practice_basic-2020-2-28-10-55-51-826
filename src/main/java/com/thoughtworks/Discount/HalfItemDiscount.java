package com.thoughtworks.Discount;

import com.thoughtworks.DataHandler.DataProvider;
import com.thoughtworks.Dish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HalfItemDiscount extends Discount implements promotion  {

    private Map<String, Integer> discountItem;

    public HalfItemDiscount( Map<String, Integer> discountItem) {
        super(discountItem);
        this.discountItem = discountItem;
    }

    public ArrayList<String> getHalfItem() {
        Iterator<Map.Entry<String, Integer>> entries = discountItem.entrySet().iterator();
        List<String> discountDishes = DataProvider.getHalfDishIds();
        ArrayList<String> halfItem = new ArrayList<>();
        while(entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            for(String value: discountDishes) {
                if(value.equals(entry.getKey())) {
                    halfItem.add(value);
                }
            }
        }
        return halfItem;
    }

    @Override
    public int getDiscountMoney() {
        int discountMoney = 0;
        Iterator<Map.Entry<String, Integer>> entries = discountItem.entrySet().iterator();
        List<String> discountDishes = DataProvider.getHalfDishIds();
        List<Dish> dishes = DataProvider.getDishes();
        while(entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            for(String value : discountDishes) {
                for(Dish dish : dishes) {
                    if (entry.getKey().equals(value) && dish.getId().equals(value)) {
                        discountMoney += entry.getValue() * (int)dish.getPrice() / 2;
                    }
                }
            }
        }
        return discountMoney;
    }

    @Override
    public String getDiscountInfo() {
        StringBuilder result = new StringBuilder();
        List<String> halfItem = getHalfItem();
        List<Dish> dishes = DataProvider.getDishes();
        Iterator<String> iterator = halfItem.iterator();
        result.append("使用优惠:\n");
        result.append("指定菜品半价(");
        if(halfItem.size() == 1) {
            result.append(halfItem.get(0));
        } else {
            while(iterator.hasNext()) {
                String id = iterator.next();
                for(Dish dish : dishes) {
                    if(dish.getId().equals(id)) {
                        result.append(dish.getName() + '，');
                    }
                }
            }
        }
        result.deleteCharAt(result.length() - 1);
        result.append(")，省" + getDiscountMoney() + "元\n");
        result.append("-----------------------------------\n");
        return result.toString();
    }
}
