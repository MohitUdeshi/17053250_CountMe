package com.example.countme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;        //for View
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView; // for linking the ImageView object
import android.view.MotionEvent; //for touch and drag event
import android.os.Bundle;
import android.util.Log;    //for log messages
import android.widget.TextView;
import java.util.Random;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;
import android.os.Vibrator;


public class MainActivity extends AppCompatActivity {


    ImageView star1, star2, star3, star4;

    ScaleAnimation scale;
    TranslateAnimation trans;
    RotateAnimation rotate;
    AlphaAnimation alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(9==8) {
            Log.i("String", "Hi");
        } else {
            Log.i("String", "No");
        }



        TextView n1, n2;


        Random leftRand = new Random();
        Random rightRand = new Random();

        n1 = findViewById(R.id.leftNum);
        int random1 = leftRand.nextInt(5);
        n1.setText(Integer.toString(random1));

        n2 = findViewById(R.id.rightNum);
        int random2 = rightRand.nextInt(4);
        n2.setText(Integer.toString(random2));



        ImageView apple1 = (ImageView) findViewById(R.id.apple1);
        apple1.setOnTouchListener(handleTouch);

        ImageView apple2 = (ImageView) findViewById(R.id.apple2);
        apple2.setOnTouchListener(handleTouch);

        ImageView apple3 = (ImageView) findViewById(R.id.apple3);
        apple3.setOnTouchListener(handleTouch);

        ImageView apple4 = (ImageView) findViewById(R.id.apple4);
        apple4.setOnTouchListener(handleTouch);

        ImageView apple5 = (ImageView) findViewById(R.id.apple5);
        apple5.setOnTouchListener(handleTouch);

        ImageView apple6 = (ImageView) findViewById(R.id.apple6);
        apple6.setOnTouchListener(handleTouch);

        ImageView apple7 = (ImageView) findViewById(R.id.apple7);
        apple7.setOnTouchListener(handleTouch);

        ImageView apple8 = (ImageView) findViewById(R.id.apple8);
        apple8.setOnTouchListener(handleTouch);

        ImageView apple9 = (ImageView) findViewById(R.id.apple9);
        apple9.setOnTouchListener(handleTouch);
    }


    TextView myTextView;
    int num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, counter = 0;

    private void vibCheck () {
        Vibrator vbr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vbr.vibrate(400);
        if (vbr.hasVibrator()) {
            Log.v("Can vibrate", "YES");
        }
    }

    public TranslateAnimation shakeError() {
        TranslateAnimation shake = new TranslateAnimation(0, 10, 0, 0);
        shake.setDuration(500);
        shake.setInterpolator(new CycleInterpolator(7));
        return shake;
    }

    public void checkAns(View v) {

        TextView leftOp = (TextView) findViewById(R.id.leftNum);
        String leftOp_text = leftOp.getText().toString();
        int leftNum1 = Integer.parseInt(leftOp_text);

        TextView rightOp = (TextView) findViewById(R.id.rightNum);
        String rightOp_text = rightOp.getText().toString();
        int rightNum1 = Integer.parseInt(rightOp_text);

        TextView ansOp = (TextView) findViewById(R.id.resultText);
        String ansOp_text = ansOp.getText().toString();
        int ans = Integer.parseInt(ansOp_text);

        TextView plusOp = findViewById(R.id.plusOp);
        TextView equalsOp = findViewById(R.id.equalsOp);

        if (leftNum1 + rightNum1 == ans) {

            View whiteView = (View) findViewById(R.id.WhiteView);
            whiteView.setVisibility(View.VISIBLE);

            View number0Inv = (View) findViewById(R.id.number0);
            number0Inv.setVisibility(View.INVISIBLE);

            View number1Inv = (View) findViewById(R.id.number1);
            number1Inv.setVisibility(View.INVISIBLE);

            View number2Inv = (View) findViewById(R.id.number2);
            number2Inv.setVisibility(View.INVISIBLE);

            View number3Inv = (View) findViewById(R.id.number3);
            number3Inv.setVisibility(View.INVISIBLE);

            View number4Inv = (View) findViewById(R.id.number4);
            number4Inv.setVisibility(View.INVISIBLE);

            View number5Inv = (View) findViewById(R.id.number5);
            number5Inv.setVisibility(View.INVISIBLE);

            View number6Inv = (View) findViewById(R.id.number6);
            number6Inv.setVisibility(View.INVISIBLE);

            View number7Inv = (View) findViewById(R.id.number7);
            number7Inv.setVisibility(View.INVISIBLE);

            View number8Inv = (View) findViewById(R.id.number8);
            number8Inv.setVisibility(View.INVISIBLE);

            View number9Inv = (View) findViewById(R.id.number9);
            number9Inv.setVisibility(View.INVISIBLE);

            View redoInv = (View) findViewById(R.id.redoButton);
            redoInv.setVisibility(View.VISIBLE);

            star1 = (ImageView) findViewById(R.id.starImage1);
            scale = new ScaleAnimation(0, 1, 0, 1);
            scale.setDuration(3500);
            scale.setRepeatCount(Animation.INFINITE);
            star1.startAnimation(scale);

            star3 = (ImageView) findViewById(R.id.starImage3);
            scale = new ScaleAnimation(0, -1, 0, -1);
            scale.setDuration(3500);
            scale.setRepeatCount(Animation.INFINITE);
            star3.startAnimation(scale);

            star2 = (ImageView) findViewById(R.id.starImage2);
            alpha = new AlphaAnimation(0, 1);
            alpha.setDuration(3500);
            alpha.setRepeatCount(Animation.INFINITE);
            star2.startAnimation(alpha);

            star4 = (ImageView) findViewById(R.id.starImage4);
            alpha = new AlphaAnimation(0, 1);
            alpha.setDuration(3500);
            alpha.setRepeatCount(Animation.INFINITE);
            star4.startAnimation(alpha);

            View correctPromptInv = (View) findViewById(R.id.correctImg);
            correctPromptInv.setVisibility(View.VISIBLE);

            leftOp.setTextColor(Color.parseColor("#00a500"));
            plusOp.setTextColor(Color.parseColor("#00a500"));
            rightOp.setTextColor(Color.parseColor("#00a500"));
            equalsOp.setTextColor(Color.parseColor("#00a500"));
            ansOp.setTextColor(Color.parseColor("#00a500"));

        } else {

            vibCheck();

            leftOp.setTextColor(Color.parseColor("#d80000"));
            plusOp.setTextColor(Color.parseColor("#d80000"));
            rightOp.setTextColor(Color.parseColor("#d80000"));
            equalsOp.setTextColor(Color.parseColor("#d80000"));
            ansOp.setTextColor(Color.parseColor("#d80000"));

            leftOp.startAnimation(shakeError());
            plusOp.startAnimation(shakeError());
            rightOp.startAnimation(shakeError());
            equalsOp.startAnimation(shakeError());
            ansOp.startAnimation(shakeError());

            //View wrongPromptInv = (View) findViewById(R.id.incorrectImg);
            //wrongPromptInv.setVisibility(View.VISIBLE);

            /*View star1Inv = (View) findViewById(R.id.starImage1);
            star1Inv.setVisibility(View.INVISIBLE);

            View star2Inv = (View) findViewById(R.id.starImage2);
            star2Inv.setVisibility(View.INVISIBLE);

            View star3Inv = (View) findViewById(R.id.starImage3);
            star3Inv.setVisibility(View.INVISIBLE);

            View star4Inv = (View) findViewById(R.id.starImage4);
            star4Inv.setVisibility(View.INVISIBLE);*/

        }


    }

    public void number0Click(View v) {
        myTextView = findViewById(R.id.resultText);
        myTextView.setText("0");
        num0 = 0;
        checkAns(v);
    }

    public void number1Click(View v) {
        myTextView = findViewById(R.id.resultText);
        myTextView.setText("1");
        num1 = 1;
        checkAns(v);
    }

    public void number2Click(View v) {
        myTextView = findViewById(R.id.resultText);
        myTextView.setText("2");
        num2 = 2;
        checkAns(v);
    }

    public void number3Click(View v) {
        myTextView = findViewById(R.id.resultText);
        myTextView.setText("3");
        num3 = 3;
        checkAns(v);
    }

    public void number4Click(View v) {
        myTextView = findViewById(R.id.resultText);
        myTextView.setText("4");
        num4 = 4;
        checkAns(v);
    }

    public void number5Click(View v) {
        myTextView = findViewById(R.id.resultText);
        myTextView.setText("5");
        num5 = 5;
        checkAns(v);
    }

    public void number6Click(View v) {
        myTextView = findViewById(R.id.resultText);
        myTextView.setText("6");
        num6 = 6;
        checkAns(v);
    }

    public void number7Click(View v) {
        myTextView = findViewById(R.id.resultText);
        myTextView.setText("7");
        num7 = 7;
        checkAns(v);
    }

    public void number8Click(View v) {
        myTextView = findViewById(R.id.resultText);
        myTextView.setText("8");
        num8 = 8;
        checkAns(v);
    }

    public void number9Click(View v) {
        myTextView = findViewById(R.id.resultText);
        myTextView.setText("9");
        num9 = 9;
        checkAns(v);
    }

    public void Restart(View v) {
        this.recreate();
    }

    private View.OnTouchListener handleTouch = new View.OnTouchListener() {
        float dX, dY;
        @Override
        public boolean onTouch(View view, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    view.animate()
                            .x(event.getRawX() + dX)
                            .y(event.getRawY() + dY)
                            .setDuration(0)
                            .start();
                    break;
                default:
                    return false;
            }
            return true;
        }
    };



}