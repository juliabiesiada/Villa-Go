package com.example.villa_go;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class DialogOnLoose extends Dialog implements View.OnClickListener {

    public Activity activity;

    private Button replayButton;
    private Button villageButton;

    public DialogOnLoose(Activity a) {
        super(a);
        this.activity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_on_loose);
        setupUI();
    }

    private void setupUI() {
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        replayButton = findViewById(R.id.btnReplay);
        villageButton = findViewById(R.id.btnVillage);
        replayButton.setOnClickListener(this);
        villageButton.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnReplay:
                Intent i_intent = new Intent(activity.getApplicationContext(), EquipmentActivity.class);
                i_intent.putExtra("caller", 3);
                activity.startActivity(i_intent);
                break;
            case R.id.btnVillage:
                Intent v_intent = new Intent(activity.getApplicationContext(), VillageActivity.class);
                activity.startActivity(v_intent);
                break;
        }
        dismiss();
    }
}