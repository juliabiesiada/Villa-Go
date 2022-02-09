package com.example.villa_go;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button continueButton;
    CardView inventoryCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    private void setupUI() {
        inventoryCardView = findViewById(R.id.inventoryCardView);
        inventoryCardView.setOnClickListener(this);
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.inventoryCardView:
                intent = new Intent(this, EquipmentActivity.class);
                startActivity(intent);
                break;
            case R.id.continueButton:
                intent = new Intent(this, VisitedVillagesActivity.class);
                startActivity(intent);
                break;

        }
    }
}