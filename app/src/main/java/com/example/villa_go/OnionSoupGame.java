package com.example.villa_go;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OnionSoupGame extends AppCompatActivity implements View.OnClickListener{

    ImageButton backBtn;
    ImageButton inventoryBtn;

    ImageView pan;
    TextView ingredientsList;
    TextView ingredient1;
    TextView ingredient2;
    TextView ingredient3;
    TextView ingredient4;
    TextView ingredient5;
    TextView ingredient6;
    TextView ingredient7;

    LinearLayout tomatoEns;
    ImageView tomatoImg;
    LinearLayout redpepperEns;
    ImageView redpepperImg;
    LinearLayout chickenEns;
    ImageView chickenImg;
    LinearLayout carrotEns;
    ImageView carrotImg;
    LinearLayout courgetteEns;
    ImageView courgetteImg;
    LinearLayout flourEns;
    LinearLayout cheeseEns;
    LinearLayout saltEns;
    LinearLayout brothEns;
    LinearLayout onionEns;
    LinearLayout breadEns;
    LinearLayout butterEns;

    int numberOfIngredients = 0;
    int lives = 3;
    boolean dragged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onion_soup_game);
        setupUI();
    }

    private void setupUI() {
        pan = findViewById(R.id.pan);
        ingredientsList = findViewById(R.id.ingredientList);
        ingredient1 = findViewById(R.id.ingredient1);
        ingredient2 = findViewById(R.id.ingredient2);
        ingredient3 = findViewById(R.id.ingredient3);
        ingredient4 = findViewById(R.id.ingredient4);
        ingredient5 = findViewById(R.id.ingredient5);
        ingredient6 = findViewById(R.id.ingredient6);
        ingredient7 = findViewById(R.id.ingredient7);

        tomatoEns = findViewById(R.id.tomato_ens);
        tomatoEns.setOnLongClickListener(longClickListener);
        tomatoImg = findViewById(R.id.tomato_img);
        redpepperEns = findViewById(R.id.redpepper_ens);
        redpepperEns.setOnLongClickListener(longClickListener);
        redpepperImg = findViewById(R.id.redpepper_img);
        chickenEns = findViewById(R.id.chicken_ens);
        chickenEns.setOnLongClickListener(longClickListener);
        chickenImg = findViewById(R.id.chicken_img);
        carrotEns = findViewById(R.id.carrot_ens);
        carrotEns.setOnLongClickListener(longClickListener);
        carrotImg = findViewById(R.id.carrot_img);
        courgetteEns = findViewById(R.id.courgette_ens);
        courgetteEns.setOnLongClickListener(longClickListener);
        courgetteImg = findViewById(R.id.courgette_img);
        flourEns = findViewById(R.id.flour_ens);
        flourEns.setOnLongClickListener(longClickListener);
        cheeseEns = findViewById(R.id.cheese_ens);
        cheeseEns.setOnLongClickListener(longClickListener);
        saltEns = findViewById(R.id.salt_ens);
        saltEns.setOnLongClickListener(longClickListener);
        brothEns = findViewById(R.id.broth_ens);
        brothEns.setOnLongClickListener(longClickListener);
        onionEns = findViewById(R.id.onion_ens);
        onionEns.setOnLongClickListener(longClickListener);
        breadEns = findViewById(R.id.bread_ens);
        breadEns.setOnLongClickListener(longClickListener);
        butterEns = findViewById(R.id.butter_ens);
        butterEns.setOnLongClickListener(longClickListener);

        pan.setOnDragListener(dragListener);

        backBtn = findViewById(R.id.backImageButton);
        backBtn.setOnClickListener(this);
        inventoryBtn = findViewById(R.id.inventoryImageButton);
        inventoryBtn.setOnClickListener(this);
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data= ClipData.newPlainText("","");
            MyDragShadowBuilder myShadowBuilder = new MyDragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder,v,0);
            return false;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_STARTED:
                    dragged = false;
                    final View view = (View) event.getLocalState();
                    if (view.getId() == R.id.tomato_ens) {
                        tomatoEns.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.flour_ens) {
                        flourEns.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.cheese_ens) {
                        cheeseEns.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.redpepper_ens) {
                        redpepperEns.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.salt_ens) {
                        saltEns.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.broth_ens) {
                        brothEns.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.chicken_ens) {
                        chickenEns.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.onion_ens) {
                        onionEns.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.carrot_ens) {
                        carrotEns.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.bread_ens) {
                        breadEns.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.courgette_ens) {
                        courgetteEns.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.butter_ens) {
                        butterEns.setVisibility(View.INVISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DROP:
                    final View view2 = (View) event.getLocalState();
                    dragged = true;
                    if (view2.getId() == R.id.tomato_ens) {
                        tomatoEns.setVisibility(View.VISIBLE);
                        tomatoEns.setOnLongClickListener(null);
                        tomatoImg.setBackground(getResources().getDrawable(R.drawable.redcross));
                        lives--;
                        checkLives();
                    } else if (view2.getId() == R.id.flour_ens) {
                        numberOfIngredients++;
                        ingredientsList.setText("Ingredients for an Onion Soup (" + numberOfIngredients +"/7):");
                        addIngredient("- Flour");
                        flourEns.setOnClickListener(null);
                    } else if (view2.getId() == R.id.cheese_ens) {
                        numberOfIngredients++;
                        ingredientsList.setText("Ingredients for an Onion Soup (" + numberOfIngredients +"/7):");
                        addIngredient("- Cheese");
                        cheeseEns.setOnClickListener(null);
                    } else if (view2.getId() == R.id.redpepper_ens) {
                        redpepperEns.setVisibility(View.VISIBLE);
                        redpepperEns.setOnLongClickListener(null);
                        redpepperImg.setBackground(getResources().getDrawable(R.drawable.redcross));
                        lives--;
                        checkLives();
                    } else if (view2.getId() == R.id.salt_ens) {
                        numberOfIngredients++;
                        ingredientsList.setText("Ingredients for an Onion Soup (" + numberOfIngredients +"/7):");
                        addIngredient("- Salt");
                        saltEns.setOnClickListener(null);
                    } else if (view2.getId() == R.id.broth_ens) {
                        numberOfIngredients++;
                        ingredientsList.setText("Ingredients for an Onion Soup (" + numberOfIngredients +"/7):");
                        addIngredient("- Broth");
                        brothEns.setOnClickListener(null);
                    } else if (view2.getId() == R.id.chicken_ens) {
                        chickenEns.setVisibility(View.VISIBLE);
                        chickenEns.setOnLongClickListener(null);
                        chickenImg.setBackground(getResources().getDrawable(R.drawable.redcross));
                        lives--;
                        checkLives();
                    } else if (view2.getId() == R.id.onion_ens) {
                        numberOfIngredients++;
                        ingredientsList.setText("Ingredients for an Onion Soup (" + numberOfIngredients +"/7):");
                        addIngredient("- Onion");
                        onionEns.setOnClickListener(null);
                    } else if (view2.getId() == R.id.carrot_ens) {
                        carrotEns.setVisibility(View.VISIBLE);
                        carrotEns.setOnLongClickListener(null);
                        carrotImg.setBackground(getResources().getDrawable(R.drawable.redcross));
                        lives--;
                        checkLives();
                    } else if (view2.getId() == R.id.bread_ens) {
                        numberOfIngredients++;
                        ingredientsList.setText("Ingredients for an Onion Soup (" + numberOfIngredients +"/7):");
                        addIngredient("- Bread");
                        breadEns.setOnClickListener(null);
                    } else if (view2.getId() == R.id.courgette_ens) {
                        courgetteEns.setVisibility(View.VISIBLE);
                        courgetteEns.setOnLongClickListener(null);
                        courgetteImg.setBackground(getResources().getDrawable(R.drawable.redcross));
                        lives--;
                        checkLives();
                    } else if (view2.getId() == R.id.butter_ens) {
                        numberOfIngredients++;
                        ingredientsList.setText("Ingredients for an Onion Soup (" + numberOfIngredients +"/7):");
                        addIngredient("- Butter");
                        butterEns.setOnClickListener(null);
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    if(!dragged) {
                        final View view3 = (View) event.getLocalState();
                        if (view3.getId() == R.id.tomato_ens) {
                            tomatoEns.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.flour_ens) {
                            flourEns.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.cheese_ens) {
                            cheeseEns.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.redpepper_ens) {
                            redpepperEns.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.salt_ens) {
                            saltEns.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.broth_ens) {
                            brothEns.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.chicken_ens) {
                            chickenEns.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.onion_ens) {
                            onionEns.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.carrot_ens) {
                            carrotEns.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.bread_ens) {
                            breadEns.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.courgette_ens) {
                            courgetteEns.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.butter_ens) {
                            butterEns.setVisibility(View.VISIBLE);
                        }
                    }
                    break;

            }
            return true;
        }
    };

    private void addIngredient(String ingredient) {
        if(numberOfIngredients==1) {
            ingredient1.setText(ingredient);
        } else if(numberOfIngredients==2) {
            ingredient2.setText(ingredient);
        } else if(numberOfIngredients==3) {
            ingredient3.setText(ingredient);
        } else if(numberOfIngredients==4) {
            ingredient4.setText(ingredient);
        } else if(numberOfIngredients==5) {
            ingredient5.setText(ingredient);
        } else if(numberOfIngredients==6) {
            ingredient6.setText(ingredient);
        } else if(numberOfIngredients==7) {
            ingredient7.setText(ingredient);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), VillageActivity.class);
                    startActivity(intent);
                    supportFinishAfterTransition();
                }
            }, 500);
        }
    }

    private void checkLives() {
        if(lives <= 0) {
            tomatoEns.setOnLongClickListener(null);
            redpepperEns.setOnLongClickListener(null);
            chickenEns.setOnLongClickListener(null);
            carrotEns.setOnLongClickListener(null);
            courgetteEns.setOnLongClickListener(null);
            flourEns.setOnLongClickListener(null);
            cheeseEns.setOnLongClickListener(null);
            saltEns.setOnLongClickListener(null);
            brothEns.setOnLongClickListener(null);
            onionEns.setOnLongClickListener(null);
            breadEns.setOnLongClickListener(null);
            butterEns.setOnLongClickListener(null);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), OnionSoupGame.class);
                    startActivity(intent);
                    supportFinishAfterTransition();
                }
            }, 500);
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.backImageButton:
                Intent intent_b = new Intent(this, VillageActivity.class);
                startActivity(intent_b);
                supportFinishAfterTransition();
                break;
            case R.id.inventoryImageButton:
                Intent intent_i = new Intent(this, EquipmentActivity.class);
                intent_i.putExtra("caller", 9);
                startActivity(intent_i);
                break;
        }
    }
}
