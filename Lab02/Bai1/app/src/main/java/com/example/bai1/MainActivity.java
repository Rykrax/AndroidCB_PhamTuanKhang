package com.example.bai1;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imgIcon;
    View item_load;
    final int[] colors = {R.color.black
            ,R.color.white
            ,R.color.orange
            ,R.color.blue
            ,R.color.red
            ,R.color.green
            ,R.color.yellow
            ,R.color.violet};
    final int[] animals = {R.drawable.ic_chameleon
            ,R.drawable.ic_crab
            ,R.drawable.ic_crocodile
            ,R.drawable.ic_fox
            ,R.drawable.ic_koala
            ,R.drawable.ic_lion
            ,R.drawable.ic_panda
            ,R.drawable.ic_penguin
            ,R.drawable.ic_shark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadApp();
    }


    public void loadApp() {
        Random rand = new Random();
        int posA = rand.nextInt(9);
        int posC = rand.nextInt(8);

        FrameLayout frameLayout = findViewById(R.id.main);
        //replace id by string
        frameLayout.setBackgroundResource(colors[posC]);

        imgIcon = findViewById(R.id.imgIcon);
        imgIcon.setImageResource(animals[posA]);
        progressBar();
    }

    public void progressBar() {
        item_load = findViewById(R.id.item_load);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            item_load.setVisibility(View.GONE); // Ẩn ProgressBar
                        }
                    });
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}