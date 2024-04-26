package com.example.mobiledesign;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class word_practice extends AppCompatActivity {

    private Button option1, option2, option3, option4;
    private int extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_word_practice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        option1 = findViewById(R.id.choise1);
        option2 = findViewById(R.id.choise2);
        option3 = findViewById(R.id.choise3);
        option4 = findViewById(R.id.choise4);



        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Установка цвета для кнопки 1
                option1.setBackgroundColor(Color.parseColor("#ff5700"));
                extra = 1;
                // Отмена выбора для кнопки
                option2.setBackgroundColor(Color.TRANSPARENT);
                option3.setBackgroundColor(Color.TRANSPARENT);
                option4.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Установка цвета для кнопки
                option2.setBackgroundColor(Color.parseColor("#ff5700"));
                extra = 2;
                // Отмена выбора для кнопки
                option1.setBackgroundColor(Color.TRANSPARENT);
                option3.setBackgroundColor(Color.TRANSPARENT);
                option4.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Установка цвета для кнопки
                option3.setBackgroundColor(Color.parseColor("#ff5700"));
                extra = 3;
                // Отмена выбора для кнопки
                option1.setBackgroundColor(Color.TRANSPARENT);
                option2.setBackgroundColor(Color.TRANSPARENT);
                option4.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Установка цвета для кнопки
                option4.setBackgroundColor(Color.parseColor("#ff5700"));
                extra = 4;
                // Отмена выбора для кнопки
                option1.setBackgroundColor(Color.TRANSPARENT);
                option2.setBackgroundColor(Color.TRANSPARENT);
                option3.setBackgroundColor(Color.TRANSPARENT);
            }
        });


    }

    public void onSubmitButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(word_practice.this, CheckWord.class);
        // Передаем идентификатор нажатой кнопки в новый Intent
        intent.putExtra("BUTTON_ID", extra);
        // Запускаем следующую активность
        startActivity(intent);
    }

    public void onbackButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(word_practice.this, main_menu.class);
        startActivity(intent);
    }

}