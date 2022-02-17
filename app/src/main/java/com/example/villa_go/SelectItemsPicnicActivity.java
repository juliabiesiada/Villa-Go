package com.example.villa_go;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectItemsPicnicActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView placeholder1;
    ImageView placeholder2;
    ImageView placeholder3;
    ImageView placeholder4;
    ImageView placeholder5;
    ImageView placeholder6;

    TextView placeholder1lbl;
    TextView placeholder2lbl;
    TextView placeholder3lbl;
    TextView placeholder4lbl;
    TextView placeholder5lbl;
    TextView placeholder6lbl;

    ImageView object1;
    ImageView object2;
    ImageView object3;
    ImageView object4;
    ImageView object5;
    ImageView object6;
    ImageView object7;
    ImageView object8;
    ImageView object9;
    ImageView object10;
    ImageView object11;
    ImageView object12;

    TextView object1lbl;
    TextView object2lbl;
    TextView object3lbl;
    TextView object4lbl;
    TextView object5lbl;
    TextView object6lbl;
    TextView object7lbl;
    TextView object8lbl;
    TextView object9lbl;
    TextView object10lbl;
    TextView object11lbl;
    TextView object12lbl;

    Button restartBtn;
    Button confirmBtn;
    ImageButton backBtn;
    ImageButton inventoryBtn;

    ArrayList<ImageView> placeholders;
    ArrayList<TextView> placeholderLabels;
    ArrayList<TextView> placeholderLabelsConst;
    HashMap<ImageView, TextView> placeholdersLabels = new HashMap<>();
    HashMap<ImageView, TextView> objectsLabels = new HashMap<>();
    HashMap<ImageView, ImageView> selectedItems = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_items_picnic);

        initializeUI();
    }

    private void initializeUI() {
        placeholder1 = findViewById(R.id.square1_placeholder);
        placeholder2 = findViewById(R.id.square2_placeholder);
        placeholder3 = findViewById(R.id.square3_placeholder);
        placeholder4 = findViewById(R.id.square4_placeholder);
        placeholder5 = findViewById(R.id.square5_placeholder);
        placeholder6 = findViewById(R.id.square6_placeholder);

        placeholder1.setTag("placeholder1");
        placeholder2.setTag("placeholder2");
        placeholder3.setTag("placeholder3");
        placeholder4.setTag("placeholder4");
        placeholder5.setTag("placeholder5");
        placeholder6.setTag("placeholder6");

        placeholder1.setOnClickListener(this);
        placeholder2.setOnClickListener(this);
        placeholder3.setOnClickListener(this);
        placeholder4.setOnClickListener(this);
        placeholder5.setOnClickListener(this);
        placeholder6.setOnClickListener(this);

        placeholder1lbl = findViewById(R.id.square1_label);
        placeholder2lbl = findViewById(R.id.square2_label);
        placeholder3lbl = findViewById(R.id.square3_label);
        placeholder4lbl = findViewById(R.id.square4_label);
        placeholder5lbl = findViewById(R.id.square5_label);
        placeholder6lbl = findViewById(R.id.square6_label);

        placeholder1lbl.setTag("placeholderLbl1");
        placeholder2lbl.setTag("placeholderLbl2");
        placeholder3lbl.setTag("placeholderLbl3");
        placeholder4lbl.setTag("placeholderLbl4");
        placeholder5lbl.setTag("placeholderLbl5");
        placeholder6lbl.setTag("placeholderLbl6");

        object1 = findViewById(R.id.vin_img);
        object2 = findViewById(R.id.poulet_img);
        object3 = findViewById(R.id.charcuterie_img);
        object4 = findViewById(R.id.pizza_img);
        object5 = findViewById(R.id.fromage_img);
        object6 = findViewById(R.id.riz_img);
        object7 = findViewById(R.id.football_img);
        object8 = findViewById(R.id.couverture_img);
        object9 = findViewById(R.id.pain_img);
        object10 = findViewById(R.id.lunettes_img);
        object11 = findViewById(R.id.chaussettes_img);
        object12 = findViewById(R.id.legumes_img);

        object1.setTag(R.drawable.wine);
        object2.setTag(R.drawable.chicken);
        object3.setTag(R.drawable.ham);
        object4.setTag(R.drawable.pizza);
        object5.setTag(R.drawable.cheese);
        object6.setTag(R.drawable.rice);
        object7.setTag(R.drawable.football);
        object8.setTag(R.drawable.blanket);
        object9.setTag(R.drawable.bread);
        object10.setTag(R.drawable.eyeglasses);
        object11.setTag(R.drawable.socks);
        object12.setTag(R.drawable.carrots);


        object1lbl = findViewById(R.id.vin_lbl);
        object2lbl = findViewById(R.id.poulet_lbl);
        object3lbl = findViewById(R.id.charcuterie_lbl);
        object4lbl = findViewById(R.id.pizza_lbl);
        object5lbl = findViewById(R.id.fromage_lbl);
        object6lbl = findViewById(R.id.riz_lbl);
        object7lbl = findViewById(R.id.football_lbl);
        object8lbl = findViewById(R.id.couverture_lbl);
        object9lbl = findViewById(R.id.pain_lbl);
        object10lbl = findViewById(R.id.lunettes_lbl);
        object11lbl = findViewById(R.id.chaussettes_lbl);
        object12lbl = findViewById(R.id.legumes_lbl);

        object1lbl.setTag("vin");
        object2lbl.setTag("poulet");
        object3lbl.setTag("charcuterie");
        object4lbl.setTag("pizza");
        object5lbl.setTag("fromage");
        object6lbl.setTag("riz");
        object7lbl.setTag("football");
        object8lbl.setTag("couverture");
        object9lbl.setTag("pain");
        object10lbl.setTag("lunettes");
        object11lbl.setTag("chaussettes");
        object12lbl.setTag("legumes");

        confirmBtn = findViewById(R.id.confirmButton);
        restartBtn = findViewById(R.id.restartButton);
        backBtn = findViewById(R.id.backImageButton);
        inventoryBtn = findViewById(R.id.inventoryImageButton);

        object1.setOnClickListener(this);
        object2.setOnClickListener(this);
        object3.setOnClickListener(this);
        object4.setOnClickListener(this);
        object5.setOnClickListener(this);
        object6.setOnClickListener(this);
        object7.setOnClickListener(this);
        object8.setOnClickListener(this);
        object9.setOnClickListener(this);
        object10.setOnClickListener(this);
        object11.setOnClickListener(this);
        object12.setOnClickListener(this);

        restartBtn.setOnClickListener(this);
        confirmBtn.setOnClickListener(this);

        backBtn.setOnClickListener(this);
        inventoryBtn.setOnClickListener(this);

        setupLists();
        tieObjectToLabel();
    }

    private void tieObjectToLabel() {
        objectsLabels.put(object1, object1lbl);
        objectsLabels.put(object2, object2lbl);
        objectsLabels.put(object3, object3lbl);
        objectsLabels.put(object4, object4lbl);
        objectsLabels.put(object5, object5lbl);
        objectsLabels.put(object6, object6lbl);
        objectsLabels.put(object7, object7lbl);
        objectsLabels.put(object8, object8lbl);
        objectsLabels.put(object9, object9lbl);
        objectsLabels.put(object10, object10lbl);
        objectsLabels.put(object11, object11lbl);
        objectsLabels.put(object12, object12lbl);

        placeholdersLabels.put(placeholder1, placeholder1lbl);
        placeholdersLabels.put(placeholder2, placeholder2lbl);
        placeholdersLabels.put(placeholder3, placeholder3lbl);
        placeholdersLabels.put(placeholder4, placeholder4lbl);
        placeholdersLabels.put(placeholder5, placeholder5lbl);
        placeholdersLabels.put(placeholder6, placeholder6lbl);

    }

    private void setupLists() {
        placeholders = new ArrayList<>();
        placeholders.add(placeholder1);
        placeholders.add(placeholder2);
        placeholders.add(placeholder3);
        placeholders.add(placeholder4);
        placeholders.add(placeholder5);
        placeholders.add(placeholder6);

        placeholderLabels = new ArrayList<>();
        placeholderLabels.add(placeholder1lbl);
        placeholderLabels.add(placeholder2lbl);
        placeholderLabels.add(placeholder3lbl);
        placeholderLabels.add(placeholder4lbl);
        placeholderLabels.add(placeholder5lbl);
        placeholderLabels.add(placeholder6lbl);
        placeholderLabelsConst = new ArrayList<>(placeholderLabels);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.restartButton:
                setupLists();
                restoreVisibility();
                clearBasket();
                break;
            case R.id.confirmButton:
                if (isCorrect()) {
                    showWinDialog();
                }
                break;
            case R.id.backImageButton:
                Intent intent_v = new Intent(this, VillageActivity.class);
                startActivity(intent_v);
                break;
            case R.id.inventoryImageButton:
                Intent intent_i = new Intent(this, EquipmentActivity.class);
                intent_i.putExtra("caller", 4);
                startActivity(intent_i);
                break;
            default:
                if (view.getTag().toString().contains("placeholder")) {
                    if (selectedItems.containsKey(view)) removeItem(view);
                } else {
                    if (placeholders.size() > 0 && placeholderLabels.size() > 0) {
                        putItem(view);
                    }
                }
        }
    }

    private void restoreVisibility() {
        for (ImageView view : objectsLabels.keySet()) {
            view.setVisibility(View.VISIBLE);
            objectsLabels.get(view).setVisibility(View.VISIBLE);
        }
    }

    private int getDrawableId(View view) {
        return (Integer)view.getTag();
    }

    private String getObjectName(View view) {
       return (String)view.getTag();
    }

    private void putItem(View view) {
        //hide the selected item
        view.setVisibility(View.INVISIBLE);
        objectsLabels.get(view).setVisibility(View.INVISIBLE);

        //put selected item in the basket
        int drawableId = getDrawableId(view);
        String name = getObjectName(objectsLabels.get(view));
        placeholders.get(0).setImageResource(drawableId);
        placeholderLabels.get(0).setText(name);

        //bound the selected item with the space in the basket
        selectedItems.put(placeholders.get(0), (ImageView)view);

        //remove the placeholder from the vacant list
        placeholders.remove(0);
        placeholderLabels.remove(0);
    }

    private void removeItem(View view) {
        //delete the image source of the placeholder and clear the label
        ((ImageView)view).setImageResource(0);
        placeholdersLabels.get(view).setText("");

        //restore the visibility of the items below
        selectedItems.get(view).setVisibility(View.VISIBLE);
        objectsLabels.get(selectedItems.get(view)).setVisibility(View.VISIBLE);

        //unbound the selected item from the space in the basket
        selectedItems.remove(view);
        
        //add the slot back to available list
        addPlaceholder((ImageView) view);
    }

    private void clearBasket() {
        //clear the bounded list
        selectedItems.clear();

        for (ImageView view : placeholdersLabels.keySet()) {
            view.setImageResource(0);
            placeholdersLabels.get(view).setText("");
        }
    }

    private void addPlaceholder(ImageView view) {
        TextView placeholderLabel = placeholdersLabels.get(view);
        int tag = Integer.parseInt(((String) view.getTag())
                .replace("placeholder", ""));
        int currentIndex = -1;

        for (ImageView placeholder : placeholders) {
            int placeholderTag = Integer.parseInt(((String) placeholder.getTag())
                    .replace("placeholder", ""));
            if (tag < placeholderTag) {
                currentIndex = placeholders.indexOf(placeholder);
                break;
            }
        }

        if (currentIndex != -1) {
            placeholders.add(currentIndex, view);
            placeholderLabels.add(currentIndex, placeholderLabel);
        }
    }

    private boolean isCorrect() {
        ArrayList<String> correctItems = new ArrayList<String>() {
            {
                add("pain");
                add("vin");
                add("fromage");
                add("charcuterie");
                add("legumes");
                add("couverture");
            }
        };

        for (TextView label : placeholderLabelsConst) {
            if (!correctItems.contains(label.getText())) {
                return false;
            }
        }
        return true;
    }

    private void showWinDialog() {
        DialogOnWin dialogOnWin = new DialogOnWin(this, "activities", "1");
        dialogOnWin.show();
    }
}