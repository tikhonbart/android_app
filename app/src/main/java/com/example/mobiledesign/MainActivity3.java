package com.example.mobiledesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Метод для обработки нажатия кнопки "Next"
    public void onNextButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(MainActivity3.this, activity_login.class);
        startActivity(intent);
    }

    // Метод для обработки нажатия кнопки "Skip"
    public void onSkipButtonClick(View view) {
        Intent intent = new Intent(MainActivity3.this, activity_login.class);
        startActivity(intent);
    }

}