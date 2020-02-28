package com.thoughtworks;

import com.thoughtworks.DataHandler.HandleDish;
import com.thoughtworks.DataHandler.ShowResult;
import com.thoughtworks.Discount.ChooseDiscount;
import com.thoughtworks.Discount.Discount;

import java.util.Map;

public class Restaurant {

  public String bestCharge(String selectedItems) {
    HandleDish newDish = new HandleDish(selectedItems);
    Map<String, Integer> dishMap = newDish.getDishes();
    ChooseDiscount choice = new ChooseDiscount(dishMap);
    Discount bestDiscount = choice.bestDiscount();
    ShowResult render = new ShowResult(dishMap);
    String result = render.showMenu(bestDiscount);
    return result;
  }
}
