package com.example.mobiledesign;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class activity_load extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_load);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Используем Handler для задержки перехода к основному экрану
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Создаем интент для перехода к основному экрану
                Intent mainIntent = new Intent(activity_load.this, MainActivity.class);
                startActivity(mainIntent);
                finish(); // Закрываем стартовый экран после перехода
            }
        }, SPLASH_DELAY);

    }


}