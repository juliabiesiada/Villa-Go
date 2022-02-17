package com.example.villa_go;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class InventoryDetailsActivity extends AppCompatActivity implements View.OnClickListener{

    String category;
    String subcategory;
    int layoutID;
    ListView lv;
    ArrayAdapter adapter;
    ImageButton backBtn;
    ImageButton inventoryBtn;
    TextView label;

    ArrayList<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_details);

        getExtras();
        parseJson(readJSON());
        setupUI();
    }

    private void getExtras() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            category = extras.getString("category").toLowerCase(Locale.ROOT);
            subcategory = extras.getString("subcategory");
        }
    }

    private String readJSON() {
        File f = new File("/data/data/" + getPackageName() + "/progress.json");
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
                InputStream is = getAssets().open("progress.json");
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

    private void parseJson(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            JSONObject levelsJSON = obj.getJSONObject("levels");
            JSONObject categoryJSON = levelsJSON.getJSONObject(category);

            Iterator<String> keys = categoryJSON.keys();

            while(keys.hasNext()) {
                String key = keys.next();
                if (categoryJSON.get(key) instanceof JSONObject) {
                    JSONObject level = (JSONObject) categoryJSON.get(key);
                    if (level.getBoolean("completed")) {
                        JSONArray categories = level.getJSONArray("category");
                        for (int i = 0; i < categories.length(); i++) {
                            if (categories.get(i).toString().equals(subcategory)) {
                                titles.add(level.getString("title"));
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void chooseDetailLayout() {
        switch (category) {
            case "cuisine":
                layoutID = R.layout.dish_list_item;
                break;

            case "activities":
                layoutID = R.layout.activities_list_item;
                break;
        }
    }

    private void setupUI() {
        chooseDetailLayout();
        if (layoutID != 0) {
            lv = findViewById(R.id.detailsListView);
            adapter = new ArrayAdapter<String>(this, layoutID, R.id.titleTV, titles);
            lv.setAdapter(adapter);
        }

        backBtn = findViewById(R.id.backImageButton);
        inventoryBtn = findViewById(R.id.inventoryImageButton);

        backBtn.setOnClickListener(this);
        inventoryBtn.setVisibility(View.GONE);

        label = findViewById(R.id.labelTV);
        String newLabel;
        if (subcategory != null ) {
            newLabel = "Paris - " + category + ": " + subcategory;
        } else {
            newLabel = "Paris - " + category;
        }
        label.setText(newLabel);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backImageButton:
                Intent intent_v = new Intent(this, EquipmentActivity.class);
                startActivity(intent_v);
                break;
        }
    }
}