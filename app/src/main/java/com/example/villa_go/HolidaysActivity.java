package com.example.villa_go;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;

public class HolidaysActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer instructions;
    MediaPlayer story;

    Button button00back;
    Button button01back;
    Button button02back;
    Button button03back;
    Button button10back;
    Button button11back;
    Button button12back;
    Button button13back;
    Button button20back;
    Button button21back;
    Button button22back;
    Button button23back;
    Button button30back;
    Button button31back;
    Button button32back;
    Button button33back;
    Button button40back;
    Button button41back;
    Button button42back;
    Button button43back;

    Button selected1;
    Button selected2;

    ImageButton backBtn;
    ImageButton inventoryBtn;

    int pairCounter = 0;

    HashMap<String, String> answers = new HashMap<>();
    HashMap<String, Integer> sounds = new HashMap<>();

    ArrayList<Button> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);

        setupUI();
        setupHashMaps();
        setupMediaPlayer();
    }

    private void setupUI() {
        button00back = findViewById(R.id.card00);
        button01back = findViewById(R.id.card01);
        button02back = findViewById(R.id.card02);
        button03back = findViewById(R.id.card03);
        button10back = findViewById(R.id.card10);
        button11back = findViewById(R.id.card11);
        button12back = findViewById(R.id.card12);
        button13back = findViewById(R.id.card13);
        button20back = findViewById(R.id.card20);
        button21back = findViewById(R.id.card21);
        button22back = findViewById(R.id.card22);
        button23back = findViewById(R.id.card23);
        button30back = findViewById(R.id.card30);
        button31back = findViewById(R.id.card31);
        button32back = findViewById(R.id.card32);
        button33back = findViewById(R.id.card33);
        button40back = findViewById(R.id.card40);
        button41back = findViewById(R.id.card41);
        button42back = findViewById(R.id.card42);
        button43back = findViewById(R.id.card43);

        backBtn = findViewById(R.id.backImageButton);
        inventoryBtn = findViewById(R.id.inventoryImageButton);

        button00back.setOnClickListener(this);
        button01back.setOnClickListener(this);
        button02back.setOnClickListener(this);
        button03back.setOnClickListener(this);
        button10back.setOnClickListener(this);
        button11back.setOnClickListener(this);
        button12back.setOnClickListener(this);
        button13back.setOnClickListener(this);
        button20back.setOnClickListener(this);
        button21back.setOnClickListener(this);
        button22back.setOnClickListener(this);
        button23back.setOnClickListener(this);
        button30back.setOnClickListener(this);
        button31back.setOnClickListener(this);
        button32back.setOnClickListener(this);
        button33back.setOnClickListener(this);
        button40back.setOnClickListener(this);
        button41back.setOnClickListener(this);
        button42back.setOnClickListener(this);
        button43back.setOnClickListener(this);

        backBtn.setOnClickListener(this);
        inventoryBtn.setOnClickListener(this);
    }

    private void setupHashMaps() {
        answers.put("15/08", "Assum-ption");
        answers.put("May / June", "Ascens-ion");
        answers.put("01/05", "Labour Day");
        answers.put("25/12 26/12", "Christ-mas");
        answers.put("11/11", "Armist-ice Day");
        answers.put("08/05", "Victory Day");
        answers.put("01/11", "All Saints' Day");
        answers.put("March / April", "Easter");
        answers.put("01/01", "New Year's Day");
        answers.put("14/07", "Bastille Day");

        buttons.add(button00back);
        buttons.add(button01back);
        buttons.add(button02back);
        buttons.add(button03back);
        buttons.add(button10back);
        buttons.add(button11back);
        buttons.add(button12back);
        buttons.add(button13back);
        buttons.add(button20back);
        buttons.add(button21back);
        buttons.add(button22back);
        buttons.add(button23back);
        buttons.add(button30back);
        buttons.add(button31back);
        buttons.add(button32back);
        buttons.add(button33back);
        buttons.add(button40back);
        buttons.add(button41back);
        buttons.add(button42back);
        buttons.add(button43back);

        sounds.put("Assum-ption", R.raw.assumptionfrench);
        sounds.put("Ascens-ion", R.raw.ascensionfrench);
        sounds.put("Labour Day", R.raw.labordayfrench);
        sounds.put("Christ-mas", R.raw.christmasfrench);
        sounds.put("Armist-ice Day", R.raw.armisticefrench);
        sounds.put("Victory Day", R.raw.victorydayfrench);
        sounds.put("All Saints' Day", R.raw.allsaintsfrench);
        sounds.put("Easter", R.raw.easterfrench);
        sounds.put("New Year's Day", R.raw.newyearfrench);
        sounds.put("Bastille Day", R.raw.bastillefrench);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backImageButton:
                Intent intent_v = new Intent(this, VillageActivity.class);
                startActivity(intent_v);
                break;
            case R.id.inventoryImageButton:
                Intent intent_i = new Intent(this, EquipmentActivity.class);
                intent_i.putExtra("caller", 10);
                startActivity(intent_i);
                break;
            default:
                handleMemoButton((Button) view);
                break;
        }
    }

    private void handleMemoButton(Button view) {
        flipCard(view);
        if (selected1 == null) {
            selected1 = view;
        } else {
            setBtnClickable(false);
            selected2 = view;
            if(checkIfCorrect(view)) {
                selected1 = null;
                selected2 = null;
                pairCounter++;
                setBtnClickable(true);
                if (pairCounter == 10) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            showWinDialog();
                        }
                    }, 500);
                }
            } else {
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    unflipBoth();
                    setBtnClickable(true);
                }, 2000);

            }
        }
    }

    private void flipCard(Button card) {
        playStory(card);
        card.setText(card.getTag().toString());
        card.setBackgroundResource(R.drawable.bg_secondary_green2);
        card.setClickable(false);
    }

    private boolean checkIfCorrect(Button view) {
        String value1 = answers.get(view.getTag().toString());
        String value2 = answers.get(selected1.getTag().toString());
        if ((value1 != null && value1.equals(selected1.getTag().toString()))
                || ((value2 != null && value2.equals(view.getTag().toString())))) {
            buttons.remove(selected1);
            buttons.remove(selected2);
            return true;
        } else {
            return false;
        }
    }

    private void unflipBoth() {
        selected1.setText("");
        selected1.setBackgroundResource(R.drawable.bg_purple);
        selected2.setText("");
        selected2.setBackgroundResource(R.drawable.bg_purple);
        selected1 = null;
        selected2 = null;
    }

    private void setBtnClickable(boolean clickable) {
        for(Button btn : buttons) {
            btn.setClickable(clickable);
        }
    }

    private void showWinDialog() {
        DialogOnWin dialogOnWin = new DialogOnWin(this, "culture", "8");
        dialogOnWin.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        instructions.stop();
        instructions.release();
    }

    private void setupMediaPlayer() {

        instructions = MediaPlayer.create(this, R.raw.holidayfrench);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                instructions.start();
            }
        }, 200);
    }

    private void playStory(Button card) {
        if (story != null &&story.isPlaying()) story.stop();
        if (sounds.get(card.getTag().toString()) != null) {
            int id = sounds.get(card.getTag().toString());
            story = MediaPlayer.create(this, id);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    story.start();
                }
            }, 100);
        }
    }
}