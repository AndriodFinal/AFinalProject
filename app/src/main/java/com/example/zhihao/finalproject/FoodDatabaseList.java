package com.example.zhihao.finalproject;

import java.util.ArrayList;
import java.util.List;

public class FoodDatabaseList {
    private  String name;
    private String calories;

    public FoodDatabaseList(String name,String calories){
        this.name=name;
        this.calories=calories;
    }

    public  static List<FoodDatabaseList> getAllFood() {
        List<FoodDatabaseList> list = new ArrayList<FoodDatabaseList>();
        list.add(new FoodDatabaseList("apple","10"));
        list.add(new FoodDatabaseList("orange","100"));

        return list;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCalories(){
        return calories;
    }
    public void setDesc(String calories){
        this.calories=calories;
    }
}
