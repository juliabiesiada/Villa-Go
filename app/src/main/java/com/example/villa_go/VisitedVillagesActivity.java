package com.example.villa_go;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class VisitedVillagesActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout visitedVillageParis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visited_villages);

        setupUI();
    }

    private void setupUI() {
        visitedVillageParis = findViewById(R.id.visitedCityParis);
        visitedVillageParis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.visitedCityParis:
                intent = new Intent(this, CuisineEscargotGame.class);
                startActivity(intent);
                break;
        }
    }
}