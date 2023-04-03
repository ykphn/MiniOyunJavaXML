package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    ImageView pcImage, userImage;
    Button rock, paper, scissors;
    TextView score;

    int pcScore = 0;
    int userScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pcImage = findViewById(R.id.Computer);
        userImage = findViewById(R.id.User);

        rock = findViewById(R.id.Rock);
        paper = findViewById(R.id.Paper);
        scissors = findViewById(R.id.Scissors);

        score = findViewById(R.id.Score);

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImage.setBackground(getResources().getDrawable(R.drawable.rock));
                Winner winner = Fighting(Selection.ROCK, PC_Chice());
                scoreTable(winner);
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImage.setBackground(getResources().getDrawable(R.drawable.paper));
                Winner winner = Fighting(Selection.PAPER, PC_Chice());
                scoreTable(winner);
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImage.setBackground(getResources().getDrawable(R.drawable.scissors));
                Winner winner = Fighting(Selection.SCISSORS, PC_Chice());
                scoreTable(winner);
            }
        });

    }

    public Selection PC_Chice() {

        int rnd = new Random().nextInt(3);

        if (rnd == 0) {
            pcImage.setBackground(getResources().getDrawable(R.drawable.rock));
            return Selection.ROCK;

        }else if (rnd == 1) {
            pcImage.setBackground(getResources().getDrawable(R.drawable.paper));
            return Selection.PAPER;

        }else {
            pcImage.setBackground(getResources().getDrawable(R.drawable.scissors));
            return Selection.SCISSORS;

        }

    }

    public Winner Fighting(Selection userS, Selection computerS) {

        if(userS.equals(computerS)) {
            return Winner.DRAW;

        } else if (userS.equals(Selection.ROCK) && computerS.equals(Selection.SCISSORS) ||
                userS.equals(Selection.PAPER) && computerS.equals(Selection.ROCK) ||
                userS.equals(Selection.SCISSORS) && computerS.equals(Selection.PAPER)) {
            return Winner.WIN;

        } else {
            return Winner.LOST;

        }

    }

    public void scoreTable(Winner winner) {
        if (winner.equals(Winner.WIN)) {
            ++userScore;
        } else if (winner.equals(Winner.LOST)) {
            ++pcScore;
        }

        score.setText("Bilgisayar: " + pcScore + " - Sen: " + userScore);
    }
}