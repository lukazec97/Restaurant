package com.example.restaurant;

import java.util.ArrayList;


public class API_Dish {

    public static ArrayList<Dish> getDishes(){
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish(1,"Maragrita","Pizza",false, 400));
        dishes.add(new Dish(2,"Caprese","Pizza",false, 450));
        dishes.add(new Dish(3,"Bolognese","paste",false, 450));
        dishes.add(new Dish(4,"Carbonare","paste",false, 450));
        dishes.add(new Dish(5,"Squids ","Sea_food", true, 300));
        dishes.add(new Dish(6,"Tuna steak ","Sea_food", true, 400));




        return dishes;
    }
}
