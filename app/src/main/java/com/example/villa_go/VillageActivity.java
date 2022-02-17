package com.example.villa_go;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import androidx.appcompat.app.AppCompatActivity;

public class VillageActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton lvlCheckIB1;
    ImageButton lvlCheckIB2;
    ImageButton lvlCheckIB3;
    ImageButton lvlCheckIB4;
    ImageButton lvlCheckIB5;
    ImageButton lvlCheckIB6;
    ImageButton lvlCheckIB7;
    ImageButton lvlCheckIB8;
    ImageButton lvlCheckIB9;

    ImageButton backBtn;
    ImageButton inventoryBtn;

    ArrayList<ImageButton> levelButtons = new ArrayList<>();
    Class[] levels = new Class[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village);
        setupUI();

        levels[0] = SelectItemsPicnicActivity.class;
        levels[1] = OnionSoupGame.class;
        levels[2] = FindTheWordGame.class;
        levels[3] = GuessTheMonumentGame.class;
        levels[4] = CompleteTheSongGame.class;
        levels[5] = CuisineEscargotGame.class;
        levels[6] = ActivityQuizActivity.class;
        levels[7] = MatchImagesAndWordsGame.class;
        levels[8] = HolidaysActivity.class;
    }

    private void setupUI() {
        lvlCheckIB1 = findViewById(R.id.lvlCheckIB1);
        lvlCheckIB2 = findViewById(R.id.lvlCheckIB2);
        lvlCheckIB3 = findViewById(R.id.lvlCheckIB3);
        lvlCheckIB4 = findViewById(R.id.lvlCheckIB4);
        lvlCheckIB5 = findViewById(R.id.lvlCheckIB5);
        lvlCheckIB6 = findViewById(R.id.lvlCheckIB6);
        lvlCheckIB7 = findViewById(R.id.lvlCheckIB7);
        lvlCheckIB8 = findViewById(R.id.lvlCheckIB8);
        lvlCheckIB9 = findViewById(R.id.lvlCheckIB9);

        backBtn = findViewById(R.id.backImageButton);
        inventoryBtn = findViewById(R.id.inventoryImageButton);

        lvlCheckIB1.setOnClickListener(this);
        lvlCheckIB2.setOnClickListener(this);
        lvlCheckIB3.setOnClickListener(this);
        lvlCheckIB4.setOnClickListener(this);
        lvlCheckIB5.setOnClickListener(this);
        lvlCheckIB6.setOnClickListener(this);
        lvlCheckIB7.setOnClickListener(this);
        lvlCheckIB8.setOnClickListener(this);
        lvlCheckIB9.setOnClickListener(this);

        levelButtons.add(lvlCheckIB1);
        levelButtons.add(lvlCheckIB2);
        levelButtons.add(lvlCheckIB3);
        levelButtons.add(lvlCheckIB4);
        levelButtons.add(lvlCheckIB5);
        levelButtons.add(lvlCheckIB6);
        levelButtons.add(lvlCheckIB7);
        levelButtons.add(lvlCheckIB8);
        levelButtons.add(lvlCheckIB9);

        backBtn.setOnClickListener(this);
        inventoryBtn.setOnClickListener(this);

        completedLevels();

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.backImageButton:
                Intent intent_b = new Intent(this, VisitedVillagesActivity.class);
                startActivity(intent_b);
                break;
            case R.id.inventoryImageButton:
                Intent intent_i = new Intent(this, EquipmentActivity.class);
                intent_i.putExtra("caller", 3);
                startActivity(intent_i);
                break;
            default:
                String idString = view.getResources().getResourceName(view.getId());
                if (idString.contains("lvlCheckIB")) {
                    int lvlNumber = Integer.parseInt(idString
                            .replace("com.example.villa_go:id/lvlCheckIB", ""));
                    if (levels[lvlNumber-1] != null) {
                        Intent intent = new Intent(this, levels[lvlNumber-1]);
                        startActivity(intent);
                    }
                }
                break;
        }

    }

    private String readJSON() {
        File f = new File("/data/data/" + getPackageName() + "/progress.json");
        String json;

        if (f.exists()) {
            FileInputStream is = null;
            try {
                is = new FileInputStream(f);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            try {
                InputStream is = getAssets().open("progress.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        return json;

    }

    private void completedLevels() {
        try {
            JSONObject obj = new JSONObject(readJSON());
            JSONObject levelsJSON = obj.getJSONObject("levels");

            Iterator<String> keys = levelsJSON.keys();

            while(keys.hasNext()) {
                String key = keys.next();
                if (levelsJSON.get(key) instanceof JSONObject) {
                    JSONObject categoryJSON = (JSONObject) levelsJSON.get(key);
                    Iterator<String> keys2 = categoryJSON.keys();

                    while(keys2.hasNext()) {
                        String key2 = keys2.next();
                        if (categoryJSON.get(key2) instanceof JSONObject) {
                            JSONObject level = (JSONObject) categoryJSON.get(key2);
                            if (level.getBoolean("completed")) {
                                int index = Integer.parseInt(key2.replace("level", "")) - 1;
                                levelButtons.get(index).setBackgroundResource(R.drawable.bg_level_complete);
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}