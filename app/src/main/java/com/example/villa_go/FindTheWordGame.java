package com.example.villa_go;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FindTheWordGame extends AppCompatActivity implements View.OnClickListener {
    // Letters
    Button l1, l2, l3, l4, l5, l6, l7, al1, al2, al3, al4, al5, al6, al7, al8, al9, al10, al11, al12, al13, al14, al15, al16;
    Button[] ls = {l1, l2, l3, l4, l5, l6, l7};
    Button[] als = {al1, al2, al3, al4, al5, al6, al7, al8, al9, al10, al11, al12, al13, al14, al15, al16};
    ArrayList<Integer> lsID = new ArrayList<>(), alsID = new ArrayList<>();
    // Lives
    ImageView firstHeart;
    ImageView secondHeart;
    ImageView thirdHeart;
    //Game values
    int lives = 3;
    String word = "voyager";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_the_word_activity);
        setupUI();
    }

    private void setupUI() {
        for(int i=0; i<ls.length; i++) {
            String id = "letter" + Integer.toString(i+1);
            int resID = getResources().getIdentifier(id, "id", getPackageName());
            ls[i] = ((Button) findViewById(resID));
            ls[i].setOnClickListener(this);
            lsID.add(resID);
        }
        for(int i=0; i<als.length; i++) {
            String id = "ansLetter" + Integer.toString(i+1);
            int resID = getResources().getIdentifier(id, "id", getPackageName());
            als[i] = ((Button) findViewById(resID));
            als[i].setOnClickListener(this);
            alsID.add(resID);
        }
        ArrayList<Integer> ansLettersToFill = new ArrayList<>();
        for(int i=0; i<als.length; i++) {
            ansLettersToFill.add(i);
        }
        ArrayList<Character> availableLetters = new ArrayList<>();
        for(int i=0; i<26; i++) {
            availableLetters.add((char) ('a' + i));
        }
        for(int i=0; i<word.length(); i++) {
            int indexToFill = (int) Math.round(Math.random() * (ansLettersToFill.size() - 1));
            als[ansLettersToFill.get(indexToFill)].setText(word.toCharArray(), i, 1);
            ansLettersToFill.remove(indexToFill);
            //availableLetters.remove((Object) word.charAt(i));
        }
        for(int i=0; i<(16-word.length()); i++) {
            int indexToFill = (int) Math.round(Math.random() * (ansLettersToFill.size()-1));
            int indexLetter = (int) Math.round(Math.random() * (availableLetters.size()-1));
            als[ansLettersToFill.get(indexToFill)].setText(arrayListToChar(availableLetters), indexLetter, 1);
            ansLettersToFill.remove(indexToFill);
            //availableLetters.remove((Object) availableLetters.get(indexLetter));
        }
        firstHeart = findViewById(R.id.firstHeart);
        secondHeart = findViewById(R.id.secondHeart);
        thirdHeart = findViewById(R.id.thirdHeart);
    }

    private char[] arrayListToChar(ArrayList<Character> al) {
        char[] myCharArray = new char[al.size()];
        for(int i = 0; i < al.size(); i++) {
            myCharArray[i] = al.get(i);
        }
        return myCharArray;
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        if(lsID.contains(view.getId())) {
            Button bl = ((Button) findViewById(view.getId()));
            if(bl.getText().length() != 0) {
                int index = 0;
                while(als[index].getText().length() != 0) index++;
                als[index].setText(bl.getText());
                bl.setText("");
            }
        } else if(alsID.contains(view.getId())) {
            Button bal = ((Button) findViewById(view.getId()));
            if(bal.getText().length() != 0) {
                int index = 0;
                while(ls[index].getText().length() != 0) index++;
                ls[index].setText(bal.getText());
                bal.setText("");
                if(index == word.length()-1) {
                    // check word
                }
            }
        }
    }
}
