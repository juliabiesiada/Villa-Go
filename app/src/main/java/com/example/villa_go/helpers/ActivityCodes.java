package com.example.villa_go.helpers;

import com.example.villa_go.ActivityQuizActivity;
import com.example.villa_go.CompleteTheSongGame;
import com.example.villa_go.CuisineEscargotGame;
import com.example.villa_go.EquipmentActivity;
import com.example.villa_go.FindTheWordGame;
import com.example.villa_go.GuessTheMonumentGame;
import com.example.villa_go.HolidaysActivity;
import com.example.villa_go.MainActivity;
import com.example.villa_go.MatchImagesAndWordsGame;
import com.example.villa_go.OnionSoupGame;
import com.example.villa_go.SelectItemsPicnicActivity;
import com.example.villa_go.VillageActivity;
import com.example.villa_go.VisitedVillagesActivity;

import java.util.HashMap;

/*
this class is built for the back button - codes are passed as extras when going to an activity
When the back arrow is pressed, this allows to retrace what was the previous activity
*/

public class ActivityCodes {
    public HashMap<Integer, Class> codesMap = new HashMap<>();

    public ActivityCodes() {
        codesMap.put(1, MainActivity.class);
        codesMap.put(2, VisitedVillagesActivity.class);
        codesMap.put(3, VillageActivity.class);
        codesMap.put(4, SelectItemsPicnicActivity.class);
        codesMap.put(5, MatchImagesAndWordsGame.class);
        codesMap.put(6, GuessTheMonumentGame.class);
        codesMap.put(7, FindTheWordGame.class);
        codesMap.put(8, EquipmentActivity.class);
        codesMap.put(9, CuisineEscargotGame.class);
        codesMap.put(10, HolidaysActivity.class);
        codesMap.put(11, CuisineEscargotGame.class);
        codesMap.put(12, OnionSoupGame.class);
        codesMap.put(13, CompleteTheSongGame.class);
        codesMap.put(14, ActivityQuizActivity.class);
    }

    public Class getCaller(int i) {
        return codesMap.get(i);
    }
}
