package com.uguremrearikan.LordOfQuiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    String stringSelectedPos;
    String nickName;
    int[]cominImages;
    int selectedPos;
    int correctAnswers;
    ImageView imgSelected;
    TextView nickNameTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        stringSelectedPos = extras.getString("position");
        nickName = extras.getString("nickname");
        cominImages=extras.getIntArray("intArray");
        selectedPos =Integer.parseInt(stringSelectedPos);
        String correctAns = extras.getString("correctAnswers");
        correctAnswers=Integer.parseInt(correctAns);
        setContentView(R.layout.activity_third);
        imgSelected=findViewById(R.id.selectedIconId);
        nickNameTxt=findViewById(R.id.nickName);
        //imgSelected.setImageResource(cominImages[selectedPos]);
        //nickNameTxt.setText(nickName);
        String score ="Your Score: "+(correctAnswers*10)+""+"/"+"80";


        makeAndDialog(score,nickName);

    }


    public void makeAndDialog(String result,String nickName){
        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        myDialog.setTitle(nickName);
        myDialog.setIcon(cominImages[selectedPos]);
        myDialog.setMessage(result);
        myDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        myDialog.create();
        myDialog.show();
    }

}