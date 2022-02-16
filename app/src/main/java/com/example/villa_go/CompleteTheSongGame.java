package com.example.villa_go;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CompleteTheSongGame extends AppCompatActivity implements View.OnClickListener{

    ImageButton backBtn;
    ImageButton inventoryBtn;

    CardView playButton;
    ImageView playIcon;
    CardView drop1;
    TextView text1;
    CardView drop2;
    TextView text2;

    CardView appetit;
    CardView deGloire;
    CardView papetrie;
    CardView deCroire;
    CardView terroir;
    CardView laPatrie;
    CardView devoir;
    CardView laFratrie;

    Button confirmButton;
    Button restartButton;

    boolean dragged = false;
    String selectOption1 = "";
    String selectOption2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_the_song_game);
        setupUI();
    }

    private void setupUI() {
        playButton = findViewById(R.id.playButton);
        playIcon = findViewById(R.id.playIcon);
        drop1 = findViewById(R.id.drop1);
        text1 = findViewById(R.id.text1);
        drop2 = findViewById(R.id.drop2);
        text2 = findViewById(R.id.text2);
        confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(this);
        restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(this);

        appetit = findViewById(R.id.appetit);
        appetit.setOnLongClickListener(longClickListener);
        deGloire = findViewById(R.id.deGloire);
        deGloire.setOnLongClickListener(longClickListener);
        papetrie = findViewById(R.id.papetrie);
        papetrie.setOnLongClickListener(longClickListener);
        deCroire = findViewById(R.id.deCroire);
        deCroire.setOnLongClickListener(longClickListener);
        terroir = findViewById(R.id.terroir);
        terroir.setOnLongClickListener(longClickListener);
        laPatrie = findViewById(R.id.laPatrie);
        laPatrie.setOnLongClickListener(longClickListener);
        devoir = findViewById(R.id.devoir);
        devoir.setOnLongClickListener(longClickListener);
        laFratrie = findViewById(R.id.laFratrie);
        laFratrie.setOnLongClickListener(longClickListener);

        drop1.setOnDragListener(dragListener1);
        drop2.setOnDragListener(dragListener2);

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

    View.OnDragListener dragListener1 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_STARTED:
                    dragged = false;
                    final View view = (View) event.getLocalState();
                    if (view.getId() == R.id.appetit) {
                        appetit.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.deGloire) {
                        deGloire.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.papetrie) {
                        papetrie.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.deCroire) {
                        deCroire.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.terroir) {
                        terroir.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.laPatrie) {
                        laPatrie.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.devoir) {
                        devoir.setVisibility(View.INVISIBLE);
                    } else if (view.getId() == R.id.laFratrie) {
                        laFratrie.setVisibility(View.INVISIBLE);
                    }
                    break;
                case DragEvent.ACTION_DROP:
                    dragged = true;
                    final View view2 = (View) event.getLocalState();
                    if (view2.getId() == R.id.appetit) {
                        appetit.setOnLongClickListener(null);
                        text1.setText("l'appétit");
                        changeSelection1("l'appétit");
                    } else if (view2.getId() == R.id.deGloire) {
                        deGloire.setOnLongClickListener(null);
                        text1.setText("de gloire");
                        changeSelection1("de gloire");
                    } else if (view2.getId() == R.id.papetrie) {
                        papetrie.setOnLongClickListener(null);
                        text1.setText("papetrie");
                        changeSelection1("papetrie");
                    } else if (view2.getId() == R.id.deCroire) {
                        deCroire.setOnLongClickListener(null);
                        text1.setText("de croire");
                        changeSelection1("de croire");
                    } else if (view2.getId() == R.id.terroir) {
                        terroir.setOnLongClickListener(null);
                        text1.setText("terroir");
                        changeSelection1("terroir");
                    } else if (view2.getId() == R.id.laPatrie) {
                        laPatrie.setOnLongClickListener(null);
                        text1.setText("la patrie");
                        changeSelection1("la patrie");
                    } else if (view2.getId() == R.id.devoir) {
                        devoir.setOnLongClickListener(null);
                        text1.setText("devoir");
                        changeSelection1("devoir");
                    } else if (view2.getId() == R.id.laFratrie) {
                        laFratrie.setOnLongClickListener(null);
                        text1.setText("la fratrie");
                        changeSelection1("la fratrie");
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    if(!dragged) {
                        final View view3 = (View) event.getLocalState();
                        if (view3.getId() == R.id.appetit) {
                            appetit.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.deGloire) {
                            deGloire.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.papetrie) {
                            papetrie.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.deCroire) {
                            deCroire.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.terroir) {
                            terroir.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.laPatrie) {
                            laPatrie.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.devoir) {
                            devoir.setVisibility(View.VISIBLE);
                        } else if (view3.getId() == R.id.laFratrie) {
                            laFratrie.setVisibility(View.VISIBLE);
                        }
                    }
                    break;
            }
            return true;
        }
    };

    private void changeSelection1(String s) {
        if(selectOption1 == "l'appétit") {
            appetit.setVisibility(View.VISIBLE);
            appetit.setOnLongClickListener(longClickListener);
        } else if(selectOption1 == "de gloire") {
            deGloire.setVisibility(View.VISIBLE);
            deGloire.setOnLongClickListener(longClickListener);
        } else if(selectOption1 == "papetrie") {
            papetrie.setVisibility(View.VISIBLE);
            papetrie.setOnLongClickListener(longClickListener);
        } else if(selectOption1 == "de croire") {
            deCroire.setVisibility(View.VISIBLE);
            deCroire.setOnLongClickListener(longClickListener);
        } else if(selectOption1 == "terroir") {
            terroir.setVisibility(View.VISIBLE);
            terroir.setOnLongClickListener(longClickListener);
        } else if(selectOption1 == "la patrie") {
            laPatrie.setVisibility(View.VISIBLE);
            laPatrie.setOnLongClickListener(longClickListener);
        } else if(selectOption1 == "devoir") {
            devoir.setVisibility(View.VISIBLE);
            devoir.setOnLongClickListener(longClickListener);
        } else if(selectOption1 == "la fratrie") {
            laFratrie.setVisibility(View.VISIBLE);
            laFratrie.setOnLongClickListener(longClickListener);
        }
        selectOption1 = s;
    }

    View.OnDragListener dragListener2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent) {
                case DragEvent.ACTION_DROP:
                    dragged = true;
                    final View view2 = (View) event.getLocalState();
                    if (view2.getId() == R.id.appetit) {
                        appetit.setOnLongClickListener(null);
                        text2.setText("l'appétit");
                        changeSelection2("l'appétit");
                    } else if (view2.getId() == R.id.deGloire) {
                        deGloire.setOnLongClickListener(null);
                        text2.setText("de gloire");
                        changeSelection2("de gloire");
                    } else if (view2.getId() == R.id.papetrie) {
                        papetrie.setOnLongClickListener(null);
                        text2.setText("papetrie");
                        changeSelection2("papetrie");
                    } else if (view2.getId() == R.id.deCroire) {
                        deCroire.setOnLongClickListener(null);
                        text2.setText("de croire");
                        changeSelection2("de croire");
                    } else if (view2.getId() == R.id.terroir) {
                        terroir.setOnLongClickListener(null);
                        text2.setText("terroir");
                        changeSelection2("terroir");
                    } else if (view2.getId() == R.id.laPatrie) {
                        laPatrie.setOnLongClickListener(null);
                        text2.setText("la patrie");
                        changeSelection2("la patrie");
                    } else if (view2.getId() == R.id.devoir) {
                        devoir.setOnLongClickListener(null);
                        text2.setText("devoir");
                        changeSelection2("devoir");
                    } else if (view2.getId() == R.id.laFratrie) {
                        laFratrie.setOnLongClickListener(null);
                        text2.setText("la fratrie");
                        changeSelection2("la fratrie");
                    }
                    break;
            }
            return true;
        }
    };

    private void changeSelection2(String s) {
        if(selectOption2 == "l'appétit") {
            appetit.setVisibility(View.VISIBLE);
            appetit.setOnLongClickListener(longClickListener);
        } else if(selectOption2 == "de gloire") {
            deGloire.setVisibility(View.VISIBLE);
            deGloire.setOnLongClickListener(longClickListener);
        } else if(selectOption2 == "papetrie") {
            papetrie.setVisibility(View.VISIBLE);
            papetrie.setOnLongClickListener(longClickListener);
        } else if(selectOption2 == "de croire") {
            deCroire.setVisibility(View.VISIBLE);
            deCroire.setOnLongClickListener(longClickListener);
        } else if(selectOption2 == "terroir") {
            terroir.setVisibility(View.VISIBLE);
            terroir.setOnLongClickListener(longClickListener);
        } else if(selectOption2 == "la patrie") {
            laPatrie.setVisibility(View.VISIBLE);
            laPatrie.setOnLongClickListener(longClickListener);
        } else if(selectOption2 == "devoir") {
            devoir.setVisibility(View.VISIBLE);
            devoir.setOnLongClickListener(longClickListener);
        } else if(selectOption2 == "la fratrie") {
            laFratrie.setVisibility(View.VISIBLE);
            laFratrie.setOnLongClickListener(longClickListener);
        }
        selectOption2 = s;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.backImageButton:
                Intent intent_b = new Intent(this, VillageActivity.class);
                startActivity(intent_b);
                break;
            case R.id.inventoryImageButton:
                Intent intent_i = new Intent(this, EquipmentActivity.class);
                intent_i.putExtra("caller", 5);
                startActivity(intent_i);
                break;
            case R.id.confirmButton:
                if(checkAnswers()) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent_c = new Intent(getApplicationContext(), VillageActivity.class);
                            startActivity(intent_c);
                            supportFinishAfterTransition();
                        }
                    }, 500);
                } else {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent_c = new Intent(getApplicationContext(), CompleteTheSongGame.class);
                            startActivity(intent_c);
                            supportFinishAfterTransition();
                        }
                    }, 500);
                }
                break;
            case R.id.restartButton:
                Intent intent_r = new Intent(this, CompleteTheSongGame.class);
                startActivity(intent_r);
                supportFinishAfterTransition();
                break;
        }

    }

    private boolean checkAnswers() {
        return selectOption1 == "la patrie" && selectOption2 == "de gloire";
    }
}

