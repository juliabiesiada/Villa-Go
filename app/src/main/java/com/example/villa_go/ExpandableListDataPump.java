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

        List<String> activities = new ArrayList<String>();
        activities.add("All activities");
        activities.add("Indoors");
        activities.add("Outdoors");
        activities.add("Spring");
        activities.add("Summer");
        activities.add("Autumn");
        activities.add("Winter");

        List<String> worthSeeing = new ArrayList<String>();
        worthSeeing.add("All");
        worthSeeing.add("Museums");
        worthSeeing.add("Outdoors");
        worthSeeing.add("Kids-friendly");
        worthSeeing.add("Evening");
        worthSeeing.add("Restaurants");
        worthSeeing.add("Cafes");

        expandableListDetail.put("LANGUAGE", language);
        expandableListDetail.put("CULTURE", culture);
        expandableListDetail.put("CUISINE", cuisine);
        expandableListDetail.put("ACTIVITIES", activities);
        expandableListDetail.put("WORTH SEEING", worthSeeing);
        return expandableListDetail;
    }
}
