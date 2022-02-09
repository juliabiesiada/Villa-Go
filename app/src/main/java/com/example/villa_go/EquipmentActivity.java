package com.example.villa_go;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUI();
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