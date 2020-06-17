package tay.fun.outsmartroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {
    AnimationDrawable Anim;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final ImageView imageView = (ImageView) findViewById(R.id.anim123);

        Button btn3=findViewById(R.id.button3);
        Button btn2=findViewById(R.id.button2);
        Button [] bir = new Button[] {btn2,btn3};
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int deviceWidth = metrics.widthPixels;
        int deviceHeight = metrics.heightPixels;
        for (Button value : bir) {

            float pertext = (float) 20 / 1793;
            int d = (int) (deviceHeight * pertext);

            if (d < 13) {
                value.setTextSize(13);
            } else {
                value.setTextSize(d);
            }
        }


        int a = (int) (deviceWidth * 0.80);
        int b = (int) (a*0.77);
        imageView.requestLayout();
        imageView.getLayoutParams().height=a;
        imageView.getLayoutParams().width=a;
        /*Intent intent = new Intent();
        Intent intent1 = new Intent();
        intent.setClassName("com.example.masterpieceroulette","com.example.masterpieceroulette.Main2Activity");
        intent1.setClassName("com.example.masterpieceroulette","com.example.masterpieceroulette.Main3Activity");
        startActivity(intent);*/

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                //intent.setClassName("tay.fun.outsmartroulette","tay.fun.outsmartroulette.Main2Activity");
                startActivity(intent);

            }
        });

















    }







}
