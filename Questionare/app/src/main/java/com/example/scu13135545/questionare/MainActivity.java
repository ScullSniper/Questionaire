package com.example.scu13135545.questionare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //variables

    private Button btnFalse;
    private Button btnTrue;
    private TextView lblQuestion;
    private ImageView imgPicture;

    private List<QuestionObject> questions;

    private QuestionObject currentQuestion;
    private int index;

    private int score;



    @Override
            protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_main);

        //connect variables to interface item
        btnFalse = (Button)findViewById(R.id.btnFalse);
        btnTrue = (Button)findViewById(R.id.btnTrue);
        lblQuestion = (TextView)findViewById(R.id.lblQuestion);
        imgPicture = (ImageView)findViewById(R.id.imgPicture);
        //set Questionaire Text
        lblQuestion.setText("is my name ....");

        //set image picture
        imgPicture.setImageResource(R.drawable.face);

        index = 0;
        score = 0;
        // onclick listeners
        btnFalse.setOnClickListener(new View.OnClickListener() {
        @Override
          public void onClick(View v) {
                determineButtonPress(false);
            }
        });

        btnTrue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                determineButtonPress(true);
            }
        });

        generateQuestions();

        setUpQuestions();


    }

    private void generateQuestions(){
        questions = new ArrayList<>();

        questions.add(new QuestionObject("London is the capital of England", true, R.drawable.england));

        questions.add(new QuestionObject("A humming birds wings beat at 80 beats a second", true, R.drawable.hummingbird));

        questions.add(new QuestionObject("A Liger is a cross between a Lemur and Linx", false, R.drawable.liger));

        questions.add(new QuestionObject("The earth is circling the moon", false, R.drawable.earth));

        questions.add(new QuestionObject("Pluto is a dwarf planet", true, R.drawable.pluto));

    }
    private void setUpQuestions(){
        currentQuestion = questions.get(index);

        lblQuestion.setText(currentQuestion.getQuestion());
        imgPicture.setImageResource(currentQuestion.getPicture());

        index++;
    }

    private void determineButtonPress(boolean answer){
        boolean expectedAnswer = currentQuestion.isAnswer();

        if (answer == expectedAnswer){
            //you were right

            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            //you were wrong

            Toast.makeText(MainActivity.this,"Wrong!", Toast.LENGTH_SHORT).show();
        }
    }

}
