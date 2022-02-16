package com.example.villa_go;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CuisineEscargotGame extends AppCompatActivity implements View.OnClickListener {

    ImageButton backBtn;
    ImageButton inventoryBtn;

    //spots spelling Escargot
    TextView E;
    CardView EUnder;
    TextView S;
    CardView SUnder;
    TextView C;
    CardView CUnder;
    TextView A;
    CardView AUnder;
    TextView RLetter;
    CardView RUnder;
    TextView G;
    CardView GUnder;
    TextView O;
    CardView OUnder;
    TextView T;
    CardView TUnder;

    //Cards with letters
    CardView TCard;
    CardView RCard;
    CardView UCard;
    CardView OCard;
    CardView SCard;
    CardView NCard;
    CardView VCard;
    CardView LCard;
    CardView BCard;
    CardView ICard;
    CardView MCard;
    CardView GCard;
    CardView YCard;
    CardView ECard;
    CardView ACard;
    CardView CCard;

    //Lives
    ImageView firstHeart;
    ImageView secondHeart;
    ImageView thirdHeart;

    //Game values
    int lives = 3;
    String wordCompleted = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuisine_escargot_letter);
        setupUI();
    }

    private void setupUI() {
        E = findViewById(R.id.ELetter);
        EUnder = findViewById(R.id.ELetterUnder);
        S = findViewById(R.id.SLetter);
        SUnder = findViewById(R.id.SLetterUnder);
        C = findViewById(R.id.CLetter);
        CUnder = findViewById(R.id.CLetterUnder);
        A = findViewById(R.id.ALetter);
        AUnder = findViewById(R.id.ALetterUnder);
        RLetter = findViewById(R.id.RLetter);
        RUnder = findViewById(R.id.RLetterUnder);
        G = findViewById(R.id.GLetter);
        GUnder = findViewById(R.id.GLetterUnder);
        O = findViewById(R.id.OLetter);
        OUnder = findViewById(R.id.OLetterUnder);
        T = findViewById(R.id.TLetter);
        TUnder = findViewById(R.id.TLetterUnder);

        TCard = findViewById(R.id.T);
        TCard.setOnClickListener(this);
        RCard = findViewById(R.id.RCard);
        RCard.setOnClickListener(this);
        UCard = findViewById(R.id.U);
        UCard.setOnClickListener(this);
        OCard = findViewById(R.id.O);
        OCard.setOnClickListener(this);
        SCard = findViewById(R.id.S);
        SCard.setOnClickListener(this);
        NCard = findViewById(R.id.N);
        NCard.setOnClickListener(this);
        VCard = findViewById(R.id.V);
        VCard.setOnClickListener(this);
        LCard = findViewById(R.id.L);
        LCard.setOnClickListener(this);
        BCard = findViewById(R.id.B);
        BCard.setOnClickListener(this);
        ICard = findViewById(R.id.I);
        ICard.setOnClickListener(this);
        MCard = findViewById(R.id.M);
        MCard.setOnClickListener(this);
        GCard = findViewById(R.id.G);
        GCard.setOnClickListener(this);
        YCard = findViewById(R.id.Y);
        YCard.setOnClickListener(this);
        ECard = findViewById(R.id.E);
        ECard.setOnClickListener(this);
        ACard = findViewById(R.id.A);
        ACard.setOnClickListener(this);
        CCard = findViewById(R.id.C);
        CCard.setOnClickListener(this);

        firstHeart = findViewById(R.id.firstHeart);
        secondHeart = findViewById(R.id.secondHeart);
        thirdHeart = findViewById(R.id.thirdHeart);

        backBtn = findViewById(R.id.backImageButton);
        backBtn.setOnClickListener(this);
        inventoryBtn = findViewById(R.id.inventoryImageButton);
        inventoryBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.E:
                if(checkGoodLetter("E")) {
                    //actualise display
                    E.setTextColor(Color.parseColor("#000000"));
                    EUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
                    SUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#93E5AB")));
                    ECard.setVisibility(View.INVISIBLE);
                    ECard.setOnClickListener(null);
                } else {
                    actualiseLives();
                }
                break;
            case R.id.S:
                if(checkGoodLetter("S")) {
                    //actualise display
                    S.setTextColor(Color.parseColor("#000000"));
                    SUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
                    CUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#93E5AB")));
                    SCard.setVisibility(View.INVISIBLE);
                    SCard.setOnClickListener(null);
                } else {
                    actualiseLives();
                }
                break;
            case R.id.C:
                if(checkGoodLetter("C")) {
                    //actualise display
                    C.setTextColor(Color.parseColor("#000000"));
                    CUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
                    AUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#93E5AB")));
                    CCard.setVisibility(View.INVISIBLE);
                    CCard.setOnClickListener(null);
                } else {
                    actualiseLives();
                }
                break;
            case R.id.A:
                if(checkGoodLetter("A")) {
                    //actualise display
                    A.setTextColor(Color.parseColor("#000000"));
                    AUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
                    RUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#93E5AB")));
                    ACard.setVisibility(View.INVISIBLE);
                    ACard.setOnClickListener(null);
                } else {
                    actualiseLives();
                }
                break;
            case R.id.RCard:
                if(checkGoodLetter("R")) {
                    //actualise display
                    RLetter.setTextColor(Color.parseColor("#000000"));
                    RUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
                    GUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#93E5AB")));
                    RCard.setVisibility(View.INVISIBLE);
                    RCard.setOnClickListener(null);
                } else {
                    actualiseLives();
                }
                break;
            case R.id.G:
                if(checkGoodLetter("G")) {
                    //actualise display
                    G.setTextColor(Color.parseColor("#000000"));
                    GUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
                    OUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#93E5AB")));
                    GCard.setVisibility(View.INVISIBLE);
                    GCard.setOnClickListener(null);
                } else {
                    actualiseLives();
                }
                break;
            case R.id.O:
                if(checkGoodLetter("O")) {
                    //actualise display
                    O.setTextColor(Color.parseColor("#000000"));
                    OUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
                    TUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#93E5AB")));
                    OCard.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ababab")));
                    OCard.setVisibility(View.INVISIBLE);
                    OCard.setOnClickListener(null);
                } else {
                    actualiseLives();
                }
                break;
            case R.id.T:
                if(checkGoodLetter("T")) {
                    //actualise display
                    T.setTextColor(Color.parseColor("#000000"));
                    TUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
                    TCard.setVisibility(View.INVISIBLE);
                    TCard.setOnClickListener(null);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(getApplicationContext(), VillageActivity.class);
                            startActivity(intent);
                            supportFinishAfterTransition();
                        }
                    }, 500);
                    break;
                } else {
                    actualiseLives();
                }
                break;
            case R.id.U:
            case R.id.N:
            case R.id.V:
            case R.id.L:
            case R.id.B:
            case R.id.I:
            case R.id.M:
            case R.id.Y:
                actualiseLives();
                break;
            case R.id.backImageButton:
                Intent intent_b = new Intent(this, VillageActivity.class);
                startActivity(intent_b);
                supportFinishAfterTransition();
                break;
            case R.id.inventoryImageButton:
                Intent intent_i = new Intent(this, EquipmentActivity.class);
                intent_i.putExtra("caller", 11);
                startActivity(intent_i);
                break;
        }
    }

    private void actualiseLives() {
        lives--;
        if (lives==2) {
            firstHeart.setBackground(getResources().getDrawable(R.drawable.empty_heart));
        } else if(lives==1) {
            secondHeart.setBackground(getResources().getDrawable(R.drawable.empty_heart));
        } else if(lives<=0) {
            thirdHeart.setBackground(getResources().getDrawable(R.drawable.empty_heart));
            reset();
        }
    }

    private void reset() {
        //display reset
        firstHeart.setBackground(getResources().getDrawable(R.drawable.full_heart));
        secondHeart.setBackground(getResources().getDrawable(R.drawable.full_heart));
        thirdHeart.setBackground(getResources().getDrawable(R.drawable.full_heart));
        E.setTextColor(Color.parseColor("#65B891"));
        S.setTextColor(Color.parseColor("#65B891"));
        C.setTextColor(Color.parseColor("#65B891"));
        A.setTextColor(Color.parseColor("#65B891"));
        RLetter.setTextColor(Color.parseColor("#65B891"));
        G.setTextColor(Color.parseColor("#65B891"));
        O.setTextColor(Color.parseColor("#65B891"));
        T.setTextColor(Color.parseColor("#65B891"));
        EUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#93E5AB")));
        SUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#616161")));
        CUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#616161")));
        AUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#616161")));
        RUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#616161")));
        GUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#616161")));
        OUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#616161")));
        TUnder.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#616161")));
        ECard.setVisibility(View.VISIBLE);
        ECard.setOnClickListener(this);
        SCard.setVisibility(View.VISIBLE);
        SCard.setOnClickListener(this);
        CCard.setVisibility(View.VISIBLE);
        CCard.setOnClickListener(this);
        ACard.setVisibility(View.VISIBLE);
        ACard.setOnClickListener(this);
        RCard.setVisibility(View.VISIBLE);
        RCard.setOnClickListener(this);
        GCard.setVisibility(View.VISIBLE);
        GCard.setOnClickListener(this);
        OCard.setVisibility(View.VISIBLE);
        OCard.setOnClickListener(this);
        TCard.setVisibility(View.VISIBLE);
        TCard.setOnClickListener(this);
        UCard.setVisibility(View.VISIBLE);
        UCard.setOnClickListener(this);
        NCard.setVisibility(View.VISIBLE);
        NCard.setOnClickListener(this);
        VCard.setVisibility(View.VISIBLE);
        VCard.setOnClickListener(this);
        LCard.setVisibility(View.VISIBLE);
        LCard.setOnClickListener(this);
        BCard.setVisibility(View.VISIBLE);
        BCard.setOnClickListener(this);
        ICard.setVisibility(View.VISIBLE);
        ICard.setOnClickListener(this);
        MCard.setVisibility(View.VISIBLE);
        MCard.setOnClickListener(this);
        YCard.setVisibility(View.VISIBLE);
        YCard.setOnClickListener(this);
        //gameplay values reset
        wordCompleted = "";
        lives = 3;
    }

    public boolean checkGoodLetter(String l) {
        boolean b = false;
        if(l=="E" && wordCompleted=="") {
            b = true;
            wordCompleted="e";
        }else if(l=="S" && wordCompleted=="e") {
            b = true;
            wordCompleted="es";
        }else if(l=="C" && wordCompleted=="es") {
            b = true;
            wordCompleted="esc";
        }else if(l=="A" && wordCompleted=="esc") {
            b = true;
            wordCompleted="esca";
        }else if(l=="R" && wordCompleted=="esca") {
            b = true;
            wordCompleted="escar";
        }else if(l=="G" && wordCompleted=="escar") {
            b = true;
            wordCompleted="escarg";
        }else if(l=="O" && wordCompleted=="escarg") {
            b = true;
            wordCompleted="escargo";
        }else if(l=="T" && wordCompleted=="escargo") {
            b = true;
            wordCompleted="escargot";
        }
        return b;
    }
}
