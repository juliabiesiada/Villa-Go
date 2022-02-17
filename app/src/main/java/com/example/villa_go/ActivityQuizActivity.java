package com.example.villa_go;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ActivityQuizActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView heart1;
    ImageView heart2;
    ImageView heart3;

    int lives = 3;

    TextView timerTV;
    TextView questionTV;
    Button answer1btn;
    Button answer2btn;
    Button answer3btn;

    ImageButton inventoryBtn;
    ImageButton backBtn;

    HashMap<String, String> answersQuestions;
    ArrayList<String> questions;
    List<String> answersAL;
    int correctAnswerIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_quiz);

        initializeUI();
        initializeQuestions();
        setupQuestion();
    }

    private void initializeUI() {

        heart1 = findViewById(R.id.firstHeart);
        heart2 = findViewById(R.id.secondHeart);
        heart3 = findViewById(R.id.thirdHeart);

        timerTV = findViewById(R.id.textView_timer);
        questionTV = findViewById(R.id.textView_question);
        answer1btn = findViewById(R.id.button_answer1);
        answer2btn = findViewById(R.id.button_answer2);
        answer3btn = findViewById(R.id.button_answer3);

        answer1btn.setOnClickListener(this);
        answer2btn.setOnClickListener(this);
        answer3btn.setOnClickListener(this);

        backBtn = findViewById(R.id.backImageButton);
        inventoryBtn = findViewById(R.id.inventoryImageButton);

        backBtn.setOnClickListener(this);
        inventoryBtn.setOnClickListener(this);
    }

    public void initializeQuestions() {
        String q1 = "This activity involves the river Seine and a boat. It is a good idea for those who want to see the city from another perspective and enjoy a nice meal or a glass of wine";
        String q2 = "A classic French game. You can see people playing it in parks around Paris, it is particularly popular among older adults";
        String q3 = "Classic parisian summer activity. It involves the outdoors, sitting on the grass in a park and enjoying delicious snacks and wine";
        String q4 = "This is an easy one. It is a way of commuting that is extremely popular among the Parisians. Hint: it involves using your muscles!";
        String q5 = "One in a kind celebration, extremely popular among the parisians. It takes place in June and involves live music on the streets, lots of it!";
        String q6 = "This activity is slightly off the beaten path, but it captures the attention of more and more parisians. It requires a little bit of investigation skills but hey, the reward is drinks!";
        String q7 = "This is actually a name of a dish, but in Paris it is a whole event. It's the most popular during winter, it involves potatoes, charcuterie and cheese... lots of cheese.";
        String q8 = "This one is quite PG18. You can watch this spectacle in places like Moulin Rouge or Lido.";
        String q9 = "An activity that is popular especially in the summer but Parisians are not afraid of cold and do it all year long. It involves drinks or coffee and judging the passing people - sitting at a...";
        String q10 = "A typical french evening activity. It involves a group of friends (or not!), snacks and drinks. A popular way for coworkers to blow off some steam after a tough day.";

        String a1 = "Bateaux Mouche_C/Pic-nique/Petanque";
        String a2 = "Wine tasting/Pétanque_C/Cabaret";
        String a3 = "Pic-nique_C/Fête de la Musique/Raclette";
        String a4 = "Promenade/Randonnée/Cycling_C";
        String a5 = "Fête du Cinéma/Fête de la Lumière/Fête de la Musique_C";
        String a6 = "Hidden bars_C/Rooftops/Cabaret";
        String a7 = "Buttes Chaumont/Raclette_C/Apéro";
        String a8 = "Cabaret_C/Soirée/Nuit Blanche";
        String a9 = "...vélo/...canape/...terrasse_C";
        String a10 = "Aperol/Promenade/Apéro_C";

        answersQuestions = new HashMap<>();
        answersQuestions.put(q1, a1);
        answersQuestions.put(q2, a2);
        answersQuestions.put(q3, a3);
        answersQuestions.put(q4, a4);
        answersQuestions.put(q5, a5);
        answersQuestions.put(q6, a6);
        answersQuestions.put(q7, a7);
        answersQuestions.put(q8, a8);
        answersQuestions.put(q9, a9);
        answersQuestions.put(q10, a10);

        questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);
        questions.add(q6);
        questions.add(q7);
        questions.add(q8);
        questions.add(q9);
        questions.add(q10);

        //randomize the order
        Collections.shuffle(questions);

    }

    private void setupQuestion() {
        String question = questions.get(0);
        String answers = answersQuestions.get(question);
        String[] answersArray = answers.split("/");
        answersAL = Arrays.asList(answersArray);
        Collections.shuffle(answersAL);

        //find the correct index
        for (int i = 0; i <= 2; i++) {
            if (answersAL.get(i).contains("_C")) {
                String temp = answersAL.get(i).replace("_C", "");
                answersAL.set(i, temp);
                correctAnswerIndex = i;
                i = 3;
            }
        }

        //setup UI
        questionTV.setText(question);
        answer1btn.setText(answersAL.get(0));
        answer2btn.setText(answersAL.get(1));
        answer3btn.setText(answersAL.get(2));
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
                intent_i.putExtra("caller", 14);
                startActivity(intent_i);
                break;
            default:
                timer.cancel();
                if(isCorrectAnswer(view)) {
                    showAnswerDialog(true);
                    answersQuestions.remove(questions.get(0));
                    questions.remove(0);
                    if (answersQuestions.size() > 0) {
                        setupQuestion();
                    } else {
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                showWinDialog();
                            }
                        }, 500);
                    }
                } else {
                    showAnswerDialog(false);
                    removeLife();
                }
                break;
        }
    }

    private boolean isCorrectAnswer(View view) {
        return Integer.parseInt(view.getTag().toString()) == correctAnswerIndex;
    }

    private void showAnswerDialog(boolean correct) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        if (correct) {
            dialog.setContentView(R.layout.dialog_correct_answer);
        } else {
            dialog.setContentView(R.layout.dialog_incorrect_answer);
        }
        dialog.show();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            dialog.dismiss();
            clearTimer();
        }, 1500);
    }

    private void showWinDialog() {
        DialogOnWin dialogOnWin = new DialogOnWin(this, "activities", "6");
        dialogOnWin.show();
    }

    private void removeLife() {
        switch (lives) {
            case 3:
                heart3.setBackgroundResource(R.drawable.empty_heart);
                lives--;
                break;
            case 2:
                heart2.setBackgroundResource(R.drawable.empty_heart);
                lives--;
                break;
            case 1:
                heart1.setBackgroundResource(R.drawable.empty_heart);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loose();
                    }
                }, 500);
        }
    }

    private void loose() {
        DialogOnLoose dialogOnLoose = new DialogOnLoose(this);
        dialogOnLoose.show();
    }

    CountDownTimer timer = new CountDownTimer(26000, 1000) {

        public void onTick(long millisUntilFinished) {
            timerTV.setText("" + millisUntilFinished / 1000);
        }

        public void onFinish() {
            timerTV.setText("0");
            removeLife();
            showAnswerDialog(false);
        }

    }.start();

    private void clearTimer() {
        timer.cancel();
        timerTV.setText("25");
        timer.start();
    }
}