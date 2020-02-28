package com.thoughtworks;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String userDish = sc.nextLine();
    Restaurant restaurant = new Restaurant();
    System.out.println(restaurant.bestCharge(userDish));
  }
}
