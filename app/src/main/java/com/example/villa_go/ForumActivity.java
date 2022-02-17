package com.example.villa_go;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class ForumActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton backButton;
    ImageButton inventoryImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        setupUI();
    }

    private void setupUI() {
        inventoryImageButton = findViewById(R.id.inventoryImageButton);
        inventoryImageButton.setOnClickListener(this);
        backButton = findViewById(R.id.backImageButton);
        backButton.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.inventoryImageButton:
                intent = new Intent(this, EquipmentActivity.class);
                intent.putExtra("caller", 1);
                startActivity(intent);
                break;
            case R.id.backImageButton:Button:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}
