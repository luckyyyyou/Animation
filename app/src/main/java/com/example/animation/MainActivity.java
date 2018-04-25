package com.example.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button start,rotate,translate,scale,objectScale,openGL,goball;
    ImageView pic;
    Camera camera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button) findViewById(R.id.start);
        rotate=(Button) findViewById(R.id.rotate);
        translate=(Button) findViewById(R.id.translate);
        scale=(Button) findViewById(R.id.scale);
        objectScale=(Button) findViewById(R.id.objectScale);
        openGL=(Button) findViewById(R.id.openGL);
        goball=(Button) findViewById(R.id.goball);
        pic=(ImageView) findViewById(R.id.picture);
//        final AnimationSet animationSet=new AnimationSet(true);
        final AlphaAnimation alphaAnimation=new AlphaAnimation(1,0);
        final RotateAnimation rotateAnimation=new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0);
        rotateAnimation.setRepeatCount(5);//重复
        final TranslateAnimation translateAnimation=new TranslateAnimation(0,200,0,300);
        final ScaleAnimation scaleAnimation=new ScaleAnimation(1,1,1,0,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);//电视机关闭效果
        final OpenGL open=new OpenGL();

        translateAnimation.setDuration(2000);
        alphaAnimation.setDuration(2000);
        rotateAnimation.setDuration(2000);
        scaleAnimation.setDuration(2000);

        goball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,BallActivity.class);
                startActivity(intent);
                finish();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pic.startAnimation(alphaAnimation);
            }
        });


        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pic.startAnimation(rotateAnimation);
            }
        });

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pic.startAnimation(translateAnimation);
            }
        });
        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(scaleAnimation);*/
                pic.startAnimation(scaleAnimation);
            }
        });

        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this,"动画开始！",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this,"动画结束！",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        final ObjectAnimator animator1=ObjectAnimator.ofFloat(
                pic,
                "alpha",
                0.5f,1f
        );
        final ObjectAnimator animator2=ObjectAnimator.ofFloat(
                pic,
                "translationX",
                300,0
        );
        final ObjectAnimator animator3=ObjectAnimator.ofFloat(
                pic,
                "scaleX",
                1f,0.5f,1f
        );
        objectScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet set=new AnimatorSet();
                set.setDuration(2000);
                set.playSequentially(animator1,animator2,animator3);
                set.start();
                Toast.makeText(MainActivity.this,"属性动画开始！",Toast.LENGTH_SHORT).show();
            }
        });

        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"属性动画！",Toast.LENGTH_SHORT).show();
            }
        });
/*        pic.animate()
                .alpha(0)
                .y(300)
                .setDuration(2000)
                .withStartAction(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"简写属性动画开始！",Toast.LENGTH_SHORT).show();
                    }
                });*/
        openGL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGL.setRotateY(10);
                openGL.startAnimation(open);



            }
        });

    }




}
