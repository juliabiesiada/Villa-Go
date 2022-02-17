package com.example.villa_go;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class DialogOnWin extends Dialog implements View.OnClickListener {

    public Activity activity;

    private Button inventoryButton;
    private Button villageButton;
    private String category;
    private String lvlNumber;

    public DialogOnWin(Activity a, String category, String lvlNumber) {
        super(a);
        this.activity = a;
        this.category = category;
        this.lvlNumber = lvlNumber;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_on_win);
        setupUI();
        updateProgress();
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
                break;
            case R.id.btnVillage:
                Intent v_intent = new Intent(activity.getApplicationContext(), VillageActivity.class);
                activity.startActivity(v_intent);
                break;
        }
        dismiss();
    }

    private String readJSON() {
        File f = new File("/data/data/" + activity.getPackageName() + "/progress.json");
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
                InputStream is = activity.getAssets().open("progress.json");
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

    private void updateProgress() {
        try {
            JSONObject obj = new JSONObject(readJSON());
            JSONObject levelsJSON = obj.getJSONObject("levels");
            JSONObject categoryJSON = levelsJSON.getJSONObject(category);

            Iterator<String> keys = categoryJSON.keys();

            while(keys.hasNext()) {
                String key = keys.next();
                if (categoryJSON.get(key) instanceof JSONObject) {
                    if (key.equals("level"+lvlNumber)) {
                        JSONObject level = (JSONObject) categoryJSON.get(key);
                        level.put("completed", true);

                        categoryJSON.put(key, level);
                        levelsJSON.put(category, categoryJSON);
                        obj.put("levels", levelsJSON);
                        FileWriter file = new FileWriter("/data/data/" +
                                activity.getApplicationContext().getPackageName() + "/progress.json");
                        file.write(obj.toString());
                        file.flush();
                        file.close();
                    }

                }
            }
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }
}