package com.example.villa_go;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class VisitedVillagesActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout parisLinearLayout;
    ImageButton backBtn;
    ImageButton inventoryBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visited_villages);
        setupUI();
    }

    private void setupUI() {
        parisLinearLayout = findViewById(R.id.visitedCityParis);
        parisLinearLayout.setOnClickListener(this);

        backBtn = findViewById(R.id.backImageButton);
        inventoryBtn = findViewById(R.id.inventoryImageButton);
        backBtn.setOnClickListener(this);
        inventoryBtn.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.visitedCityParis:
                intent = new Intent(this, VillageActivity.class);
                startActivity(intent);
                break;
            case R.id.backImageButton:
                Intent intent_b = new Intent(this, MainActivity.class);
                startActivity(intent_b);
                break;
            case R.id.inventoryImageButton:
                Intent intent_i = new Intent(this, EquipmentActivity.class);
                intent_i.putExtra("caller", 2);
                startActivity(intent_i);
                break;
        }
    }
}