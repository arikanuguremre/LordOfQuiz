package com.uguremrearikan.LordOfQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private ScrollView scroll;
    ImageView imgSelected;
    TextView nickNameTxt,ringNumber;
    SeekBar blueSeekBar;
    int seventhQuestionComing,SEVENTHQUESTIONANSWER;
    private RadioButton question1;
    private RadioButton question2;
    private RadioButton question3;
    private RadioButton question4;
    private RadioButton question5;
    private RadioButton question6;
    private RadioGroup radioGroupOne;
    private RadioGroup radioGroupTwo;
    private RadioGroup radioGroupThree;
    private RadioGroup radioGroupFour;
    private RadioGroup radioGroupFive;
    private RadioGroup radioGroupSix;
    private CheckBox question8_1;
    private CheckBox question8_3;
    private CheckBox question8_4;
    private CheckBox wrongAnswerEight;
    String stringSelectedPos;
    String nickName;
    int[]cominImages;
    int selectedPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        stringSelectedPos = extras.getString("position");
        nickName = extras.getString("nickname");
        cominImages=extras.getIntArray("intArray");
        selectedPos =Integer.parseInt(stringSelectedPos);

        setContentView(R.layout.activity_second);
        scroll =  findViewById(R.id.Scroll);
        ringNumber=findViewById(R.id.ringNumber);
        blueSeekBar=findViewById(R.id.seekBarBlue);
        nickNameTxt=findViewById(R.id.nickName);
        imgSelected=findViewById(R.id.selectedIconId);
        imgSelected.setImageResource(cominImages[selectedPos]);
        nickNameTxt.setText(nickName);

        //correct questions
        question1 = findViewById(R.id.rb_CorrectAnswerOne);
        question2 = findViewById(R.id.rb_CorrectAnswerTwo);
        question3 = findViewById(R.id.rb_CorrectAnswerThree);
        question4 = findViewById(R.id.rb_CorrectAnswerFour);
        question5 = findViewById(R.id.rb_CorrectAnswerFive);
        question6 = findViewById(R.id.rb_CorrectAnswerSix);

        question8_1 =findViewById(R.id.cb_CorrectAnswerEight_1);
        question8_3 =findViewById(R.id.cb_CorrectAnswerEight_3);
        question8_4 =findViewById(R.id.cb_CorrectAnswerEight_4);

        wrongAnswerEight = findViewById(R.id.cb_WrongAnswerEight);
        SEVENTHQUESTIONANSWER=20;

        radioGroupOne=   findViewById(R.id.radioGroupOne);
        radioGroupTwo=   findViewById(R.id.radioGroupTwo);
        radioGroupThree= findViewById(R.id.radioGroupThree);
        radioGroupFour=  findViewById(R.id.radioGroupFour);
        radioGroupFive=  findViewById(R.id.radioGroupFive);
        radioGroupSix=   findViewById(R.id.radioGroupSix);


        ringNumber.setText("Use Seek-Bar !");
        blueSeekBar.setMax(30);
        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                seventhQuestionComing =progress;
                ringNumber.setText(getString(R.string.unicodeRingSymbol)+" "+seventhQuestionComing);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void SubmitResponse(View v){
        String wrongAnswers = "Check this question and try again :-\n";
        int correctAnswers=0;
        if (question1.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 1\n";
        }

        if (question2.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 2\n";
        }
        if (question3.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 3\n";
        }

        if (question4.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Question - 4\n";
        }

        if(question5.isChecked()){
            correctAnswers++;
        }else{
            wrongAnswers = wrongAnswers + "Question - 5\n";
        }
        if(question6.isChecked()){
            correctAnswers++;
        }else{
            wrongAnswers = wrongAnswers + "Question - 6\n";
        }

        if(seventhQuestionComing == SEVENTHQUESTIONANSWER){
            correctAnswers++;
        }else{
            wrongAnswers = wrongAnswers + "Question - 7\n";
        }

        if (question8_1.isChecked() && question8_3.isChecked() && question8_4.isChecked() && !(wrongAnswerEight.isChecked())){
            correctAnswers++;
        }else{
            wrongAnswers = wrongAnswers + "Question - 8\n";
        }

        if (correctAnswers == 8) {
            Toast.makeText(this, "Congrats, All Answers Correct  \n Thanks for attempting this Quiz ", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Correct Answers: " + correctAnswers + " /8\n" + wrongAnswers, Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
        Bundle extras = new Bundle();
        extras.putString("correctAnswers",correctAnswers+"");
        extras.putString("nickname",nickName);
        extras.putString("position",selectedPos+"");
        extras.putIntArray("intArray",cominImages);
        intent.putExtras(extras);
        startActivity(intent);

    }




    public void ResetQuiz(View v){


        radioGroupOne.clearCheck();
        radioGroupTwo.clearCheck();
        radioGroupThree.clearCheck();
        radioGroupFour.clearCheck();
        radioGroupFive.clearCheck();
        radioGroupSix.clearCheck();

        if (question8_1.isChecked()) {
            question8_1.toggle();
        }

        if (question8_3.isChecked()) {
            question8_3.toggle();
        }

        if (question8_4.isChecked()) {
            question8_4.toggle();
        }

        if (wrongAnswerEight.isChecked()) {
            wrongAnswerEight.toggle();
        }
        scroll.fullScroll(ScrollView.FOCUS_UP);
    }


}