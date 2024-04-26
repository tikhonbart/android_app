package com.example.mobiledesign;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.view.View;
import android.graphics.Color;

public class lan_choice extends AppCompatActivity {

    private Button btnrus;
    private Button btnEn;
    private Button btnCh;
    private Button btnBel;
    private Button btnKz;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lan_choice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnrus = findViewById(R.id.lan1);
        btnEn = findViewById(R.id.lan2);
        btnCh = findViewById(R.id.lan3);
        btnBel = findViewById(R.id.lan4);
        btnKz = findViewById(R.id.lan5);

        submit = findViewById(R.id.submit);

        btnrus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Установка цвета для кнопки 1
                btnrus.setBackgroundColor(Color.parseColor("#ff5700"));
                // Отмена выбора для кнопки
                btnEn.setBackgroundColor(Color.TRANSPARENT);
                btnCh.setBackgroundColor(Color.TRANSPARENT);
                btnBel.setBackgroundColor(Color.TRANSPARENT);
                btnKz.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        btnEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Установка цвета для кнопки
                btnEn.setBackgroundColor(Color.parseColor("#ff5700"));
                // Отмена выбора для кнопки
                btnrus.setBackgroundColor(Color.TRANSPARENT);
                btnCh.setBackgroundColor(Color.TRANSPARENT);
                btnBel.setBackgroundColor(Color.TRANSPARENT);
                btnKz.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        btnCh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Установка цвета для кнопки
                btnCh.setBackgroundColor(Color.parseColor("#ff5700"));
                // Отмена выбора для кнопки
                btnrus.setBackgroundColor(Color.TRANSPARENT);
                btnEn.setBackgroundColor(Color.TRANSPARENT);
                btnBel.setBackgroundColor(Color.TRANSPARENT);
                btnKz.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        btnBel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Установка цвета для кнопки
                btnBel.setBackgroundColor(Color.parseColor("#ff5700"));
                // Отмена выбора для кнопки
                btnrus.setBackgroundColor(Color.TRANSPARENT);
                btnCh.setBackgroundColor(Color.TRANSPARENT);
                btnEn.setBackgroundColor(Color.TRANSPARENT);
                btnKz.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        btnKz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Установка цвета для кнопки
                btnKz.setBackgroundColor(Color.parseColor("#ff5700"));
                // Отмена выбора для кнопки
                btnrus.setBackgroundColor(Color.TRANSPARENT);
                btnCh.setBackgroundColor(Color.TRANSPARENT);
                btnBel.setBackgroundColor(Color.TRANSPARENT);
                btnEn.setBackgroundColor(Color.TRANSPARENT);
            }
        });


    }
    public void onSubmitButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(lan_choice.this, main_menu.class);
        startActivity(intent);
    }

    public void onbackButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(lan_choice.this, activity_login.class);
        startActivity(intent);
    }

}