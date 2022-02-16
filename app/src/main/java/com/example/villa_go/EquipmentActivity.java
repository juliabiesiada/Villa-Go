package com.example.villa_go;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.villa_go.helpers.ActivityCodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EquipmentActivity extends AppCompatActivity {

    ExpandableListView expandableListViewLanguage;
    ExpandableListView expandableListViewCulture;
    ExpandableListView expandableListViewCuisine;
    ExpandableListAdapter expandableListAdapterLanguage;
    ExpandableListAdapter expandableListAdapterCulture;
    ExpandableListAdapter expandableListAdapterCuisine;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    ImageButton backButton;
    ImageButton equipmentButton;

    int callerCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUI();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            callerCode = extras.getInt("caller");
        }
    }

    private void setupUI() {
        setContentView(R.layout.activity_equipment);

        expandableListViewLanguage = findViewById(R.id.expandableListViewLanguage);
        expandableListViewCulture = findViewById(R.id.expandableListViewCulture);
        expandableListViewCuisine = findViewById(R.id.expandableListViewCuisine);

        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());

        expandableListAdapterLanguage = new ExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListViewLanguage.setAdapter(expandableListAdapterLanguage);
        expandableListAdapterCulture = new ExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListViewCulture.setAdapter(expandableListAdapterCulture);
        expandableListAdapterCuisine = new ExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListViewCuisine.setAdapter(expandableListAdapterCuisine);

        setupExpandableGroupListeners(expandableListViewLanguage);
        setupExpandableGroupListeners(expandableListViewCulture);
        setupExpandableGroupListeners(expandableListViewCuisine);

        backButton = findViewById(R.id.backImageButton);
        equipmentButton = findViewById(R.id.inventoryImageButton);
        //hide because we're already in activity
        equipmentButton.setVisibility(View.GONE);

        //add listener and check what was the calling activity
        backButton.setOnClickListener((View v) -> {
            if (callerCode > 0) {
                ActivityCodes ac = new ActivityCodes();
                Class a = ac.getCaller(callerCode);
                Intent intent = new Intent(this, a);
                startActivity(intent);
            }
        });
    }

    private void setupExpandableGroupListeners(ExpandableListView lv) {
        lv.setOnGroupExpandListener(groupPosition -> Toast.makeText(getApplicationContext(),
                expandableListTitle.get(groupPosition) + " List Expanded.",
                Toast.LENGTH_SHORT).show());

        lv.setOnGroupCollapseListener(groupPosition -> Toast.makeText(getApplicationContext(),
                expandableListTitle.get(groupPosition) + " List Collapsed.",
                Toast.LENGTH_SHORT).show());

        /*lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });*/
    }

}