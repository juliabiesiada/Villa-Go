package com.example.villa_go;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class VisitedVillagesActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout parisLinearLayout;
    ImageView parisImageView;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visited_villages);
        setupUI();
    }

    private void setupUI() {
        //parisImageView = findViewById(R.id.parisImageView);
        //parisImageView.setOnClickListener(this);
        parisLinearLayout = findViewById(R.id.visitedCityParis);
        parisLinearLayout.setOnClickListener(this);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(this);
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
            case R.id.backButton:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            /*case R.id.parisImageView:
                Intent intent = new Intent(this, VillageActivity.class);
                startActivity(intent);*/
        }
    }
}