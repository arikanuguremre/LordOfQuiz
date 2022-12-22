package com.uguremrearikan.LordOfQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    TextView myBrandBlink;
    EditText nickName;
    Button btnStart;
    ImageView elvenPng;
    // Animation
    Animation animBlink;
    String[] names =
            {
                    "Aragorn",
                    "Balrog",
                    "Durin",
                    "Galadriel",
                    "Gandalf",
                    "Gilgalad",
                    "Gimli",
                    "Legolas",
                    "Saruman",
                    "Sauron"};

    int[] images ={
            R.drawable.aragorn,
            R.drawable.balrog,
            R.drawable.durin,
            R.drawable.galadriel,
            R.drawable.gandalf,
            R.drawable.gilgalad,
            R.drawable.gimli,
            R.drawable.legolas,
            R.drawable.saruman,
            R.drawable.sauron};

    int selectedPosition;
    String nick;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBrandBlink=findViewById(R.id.brandName1);
        btnStart=findViewById(R.id.btnStart);
        nickName=findViewById(R.id.nickNameTxt);
        elvenPng=findViewById(R.id.elvenpng);
        Spinner spin = findViewById(R.id.spinner);
        btnStart.setBackgroundColor(Color.DKGRAY);
        // load the animation
        animBlink = AnimationUtils.loadAnimation(this,R.anim.blink);
        // set animation listener
        animBlink.setAnimationListener(this);
        // start the animation
        myBrandBlink.setVisibility(View.VISIBLE);
        myBrandBlink.startAnimation(animBlink);

        //animate ImageView
        rotate_Clockwise(elvenPng);



        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> paren,View view,int position,long id) {
                Toast.makeText(MainActivity.this,"Your avatar is "+names[position], Toast.LENGTH_SHORT).show();
                selectedPosition=position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),images,names);
        spin.setAdapter(customAdapter);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isEmpty(nickName)==false){
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    Bundle extras = new Bundle();
                     nick = nickName.getText().toString();
                    Log.println(Log.ERROR,"NICKNAME:",nick);
                    extras.putString("nickname",nick);
                    extras.putString("position",selectedPosition+"");
                    extras.putIntArray("intArray",images);

                    intent.putExtras(extras);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Please Enter a nick name!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation
        // check for blink animation
        if (animation == animBlink) {
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }

    public void rotate_Clockwise(View view){
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 359f, 0f);
        rotate.setRepeatCount(1000);
        rotate.setDuration(10000);
        rotate.start();
    }
}