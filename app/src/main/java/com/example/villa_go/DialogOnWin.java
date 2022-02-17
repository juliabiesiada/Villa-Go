package com.example.villa_go;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class DialogOnWin extends Dialog implements View.OnClickListener {

    public Activity activity;

    private Button inventoryButton;
    private Button villageButton;

    public DialogOnWin(Activity a) {
        super(a);
        this.activity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_on_win);
        setupUI();
    }

    private void setupUI() {
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        inventoryButton = findViewById(R.id.btnInventory);
        villageButton = findViewById(R.id.btnVillage);
        inventoryButton.setOnClickListener(this);
        villageButton.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnInventory:
                Intent i_intent = new Intent(activity.getApplicationContext(), EquipmentActivity.class);
                i_intent.putExtra("caller", 3);
                activity.startActivity(i_intent);
                activity.finish();
                break;
            case R.id.btnVillage:
                Intent v_intent = new Intent(activity.getApplicationContext(), VillageActivity.class);
                activity.startActivity(v_intent);
                break;
        }
        dismiss();
    }
}