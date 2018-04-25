package com.example.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Danni on 2017/9/15.
 */

public class BallActivity extends AppCompatActivity {

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball);
        back=(Button) findViewById(R.id.back);
        final View ball=(View) findViewById(R.id.ball);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BallActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        final OpenGL open=new OpenGL();
        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ball.startAnimation(open);
            }
        });


    }
}
