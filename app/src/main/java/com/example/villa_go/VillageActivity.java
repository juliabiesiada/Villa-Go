package com.example.villa_go;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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
    ImageButton lvlCheckIB10;
    ImageButton lvlCheckIB11;
    ImageButton lvlCheckIB12;
    ImageButton lvlCheckIB13;

    ImageButton backBtn;
    ImageButton inventoryBtn;

    Class[] levels = new Class[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village);
        setupUI();

        //TODO: Setup levels array
        levels[1] = SelectItemsPicnicActivity.class;
        levels[2] = OnionSoupGame.class;
        levels[3] = FindTheWordGame.class;
        levels[4] = GuessTheMonumentGame.class;
        levels[5] = CompleteTheSongGame.class;
        levels[6] = CuisineEscargotGame.class;
        levels[7] = ActivityQuizActivity.class;
        levels[11] = MatchImagesAndWordsGame.class;
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
        lvlCheckIB10 = findViewById(R.id.lvlCheckIB10);
        lvlCheckIB11 = findViewById(R.id.lvlCheckIB11);
        lvlCheckIB12 = findViewById(R.id.lvlCheckIB12);
        lvlCheckIB13 = findViewById(R.id.lvlCheckIB13);

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
        lvlCheckIB10.setOnClickListener(this);
        lvlCheckIB11.setOnClickListener(this);
        lvlCheckIB12.setOnClickListener(this);
        lvlCheckIB13.setOnClickListener(this);

        backBtn.setOnClickListener(this);
        inventoryBtn.setOnClickListener(this);

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
}