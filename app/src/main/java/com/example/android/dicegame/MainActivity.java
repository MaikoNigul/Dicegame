package com.example.android.dicegame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();// teeb randomi millega saame random arve.
    private Button rollDices;
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollDices = (Button) findViewById(R.id.rollDices);//Otsime kõik Buttonid ja ImageViewd ülesse layoutist.
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        rollDices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value1 = randomDiceValue();// Võtab randomDiceValuest 1 arvu ja salvestab selle value1 muutujasse
                int value2 = randomDiceValue();// Võtab randomDiceValuest 1 arvu ja salvestab selle value2 muutujasse

                int res1 = getResources().getIdentifier("dice_" + value1, "drawable", "com.example.android.dicegame");//Võtab value1 ja võtab selle väärtusega vastava pidli ja salvestab selle muutujasse
                int res2 = getResources().getIdentifier("dice_" + value2, "drawable", "com.example.android.dicegame");

                imageView1.setImageResource(res1);// Muudab imageViewd õige väärtusega täringuks.
                imageView2.setImageResource(res2);
            }
        });
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;// Võtab suvalise arvu 1-6.
    }
}