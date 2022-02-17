package com.example.villa_go;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MatchImagesAndWordsGame extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer instructions;

    // Buttons
    Button word1, word2, word3, word4;
    ImageButton image1, image2, image3, image4;
    Button[] ws = {word1, word2, word3, word4};
    ImageButton[] ims = {image1, image2, image3, image4};
    ArrayList<Integer> wsID = new ArrayList<>(), imsID = new ArrayList<>();
    // Top bar
    ImageButton backButton;
    ImageButton inventoryButton;
    // Lives
    ImageView firstHeart;
    ImageView secondHeart;
    ImageView thirdHeart;
    //Game values
    int lives = 3;
    ImageButton selected = null;
    int found = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_images_and_words_activity);
        setupUI();
    }
    private void setupUI() {
        backButton = findViewById(R.id.backImageButton);
        backButton.setOnClickListener(this);
        inventoryButton = findViewById(R.id.inventoryImageButton);
        inventoryButton.setOnClickListener(this);

        for(int i=0; i<ws.length; i++) {
            String id = "word" + Integer.toString(i+1);
            int resID = getResources().getIdentifier(id, "id", getPackageName());
            ws[i] = ((Button) findViewById(resID));
            ws[i].setOnClickListener(this);
            wsID.add(resID);
        }
        for(int i=0; i<ims.length; i++) {
            String id = "image" + Integer.toString(i+1);
            int resID = getResources().getIdentifier(id, "id", getPackageName());
            ims[i] = ((ImageButton) findViewById(resID));
            ims[i].setOnClickListener(this);
            imsID.add(resID);
        }

        firstHeart = findViewById(R.id.firstHeart);
        secondHeart = findViewById(R.id.secondHeart);
        thirdHeart = findViewById(R.id.thirdHeart);

        instructions = MediaPlayer.create(this, R.raw.matchfrench);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                instructions.start();
            }
        }, 200);
    }

    private void actualiseLives() {
        lives--;
        if (lives==2) {
            firstHeart.setBackground(getResources().getDrawable(R.drawable.empty_heart));
        } else if(lives==1) {
            secondHeart.setBackground(getResources().getDrawable(R.drawable.empty_heart));
        } else if(lives==0) {
            thirdHeart.setBackground(getResources().getDrawable(R.drawable.empty_heart));
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loose();
                }
            }, 500);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        Intent intent;
        if(imsID.contains(view.getId())) {
            if(selected != null) {
                selected.setBackgroundTintList(view.getContext().getResources().getColorStateList(R.color.ansLetterGray));
            }
            selected = ((ImageButton) findViewById(view.getId()));
            selected.setBackgroundTintList(view.getContext().getResources().getColorStateList(R.color.selected));
        } if(wsID.contains(view.getId()) && selected != null) {
            Button bw = ((Button) findViewById(view.getId()));
            if(Integer.parseInt(bw.getResources().getResourceName(bw.getId()).replace("com.example.villa_go:id/word", "")) == Integer.parseInt(selected.getResources().getResourceName(selected.getId()).replace("com.example.villa_go:id/image", ""))) {
                bw.setVisibility(View.INVISIBLE);
                selected.setVisibility(View.INVISIBLE);
                found++;
                if(found == ims.length) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showWinDialog();
                        }
                    }, 500);
                }
            } else {
                actualiseLives();
            }
            selected.setBackgroundTintList(view.getContext().getResources().getColorStateList(R.color.ansLetterGray));
            selected = null;
        } else {
            switch(view.getId()) {
                case R.id.backImageButton: {
                    intent = new Intent(this, VillageActivity.class);
                    startActivity(intent);
                    break;
                }
                case R.id.inventoryImageButton: {
                    intent = new Intent(this, EquipmentActivity.class);
                    intent.putExtra("caller", 5);
                    startActivity(intent);
                    break;
                }
            }
        }
    }

    private void showWinDialog() {
        DialogOnWin dialogOnWin = new DialogOnWin(this);
        dialogOnWin.show();
    }

    private void loose() {
        DialogOnLoose dialogOnLoose = new DialogOnLoose(this);
        dialogOnLoose.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        instructions.stop();
        instructions.release();
    }
}
