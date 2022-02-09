package com.example.villa_go;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> language = new ArrayList<String>();
        language.add("Greetings");
        language.add("Dining");
        language.add("Navigation");
        language.add("Shopping");

        List<String> culture = new ArrayList<String>();
        culture.add("Public transport");
        culture.add("Restaurant");
        culture.add("Meeting people");

        List<String> cuisine = new ArrayList<String>();
        cuisine.add("All dishes");
        cuisine.add("Breakfast");
        cuisine.add("Lunch");
        cuisine.add("Dinner");
        cuisine.add("Dessert");
        cuisine.add("Cheese");

        expandableListDetail.put("LANGUAGE", language);
        expandableListDetail.put("CULTURE", culture);
        expandableListDetail.put("CUISINE", cuisine);
        return expandableListDetail;
    }
}
