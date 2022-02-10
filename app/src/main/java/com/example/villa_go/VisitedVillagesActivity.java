package com.example.villa_go;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class VisitedVillagesActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView parisImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visited_villages);
        setupUI();
    }

    private void setupUI() {
        parisImageView = findViewById(R.id.parisImageView);
        parisImageView.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.parisImageView:
                Intent intent = new Intent(this, VillageActivity.class);
                startActivity(intent);
        }
    }
}