package com.thoughtworks.DataHandler;

import com.thoughtworks.Discount.ChooseDiscount;
import com.thoughtworks.Discount.Discount;
import com.thoughtworks.Dish;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShowResult {
    private Map<String, Integer> Dishes;

    public ShowResult(Map<String, Integer> Dishes) {
        this.Dishes = Dishes;
    }

    public String showMenu(Discount discount) {
        StringBuilder info = new StringBuilder();
        info.append("============= 订餐明细 =============\n");
        Iterator<Map.Entry<String, Integer>> entries = Dishes.entrySet().iterator();
        List<Dish> dishes = DataProvider.getDishes();
        ChooseDiscount choice = new ChooseDiscount(Dishes);
        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            for (Dish dish : dishes) {
                if (entry.getKey().equals(dish.getId())) {
                    info.append(dish.getName() + " x " + entry.getValue() + " = " + entry.getValue()
                            * (int)dish.getPrice() + "元\n");
                }
            }
        }
        info.append("-----------------------------------\n");
        info.append(discount.getDiscountInfo());
        info.append("总计：" + (choice.getTotalPrice() - discount.getDiscountMoney()) + "元\n");
        info.append("===================================");
        return info.toString();
    }
}
