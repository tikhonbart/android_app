package com.example.mobiledesign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckWord extends AppCompatActivity {

    private Button option1, option2, option3, option4;
    private int selectedOptionId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_word);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        option1 = findViewById(R.id.choise1);
        option2 = findViewById(R.id.choise2);
        option3 = findViewById(R.id.choise3);
        option4 = findViewById(R.id.choise4);



        int buttonId = getIntent().getIntExtra("BUTTON_ID", 0);
        //Button selectedButton = findViewById(buttonId);

        // Проверка, какая кнопка была нажата
        if (buttonId == 1) {
            option1.setBackgroundColor(Color.parseColor("#e9005c"));
            option2.setBackgroundColor(Color.parseColor("#39ab8f"));
        } else if (buttonId == 2) {
            option2.setBackgroundColor(Color.parseColor("#39ab8f"));
        } else if (buttonId == 3) {
            option3.setBackgroundColor(Color.parseColor("#e9005c"));
            option2.setBackgroundColor(Color.parseColor("#39ab8f"));
        } else if (buttonId == 4) {
            option4.setBackgroundColor(Color.parseColor("#e9005c"));
            option2.setBackgroundColor(Color.parseColor("#39ab8f"));
        }

    }

    public void checkAnswer(View view) {
        // Получаем id кнопки, на которую было нажато
        int selectedOptionId = view.getId();

        // Устанавливаем все кнопки в изначальный цвет
        option1.setBackgroundColor(Color.TRANSPARENT);
        option2.setBackgroundColor(Color.TRANSPARENT);
        option3.setBackgroundColor(Color.TRANSPARENT);
        option4.setBackgroundColor(Color.TRANSPARENT);

        // Проверяем правильность ответа и меняем цвет кнопки
        if (selectedOptionId == R.id.choise1) {
            // Если выбран вариант 1 (неверный ответ)
            option1.setBackgroundColor(Color.RED);
        } else if (selectedOptionId == R.id.choise2) {
            // Если выбран вариант 2 (верный ответ)
            option2.setBackgroundColor(Color.GREEN);
        } else if (selectedOptionId == R.id.choise3) {
            // Если выбран вариант 3 (неверный ответ)
            option3.setBackgroundColor(Color.RED);
        } else if (selectedOptionId == R.id.choise4) {
            // Если выбран вариант 4 (неверный ответ)
            option4.setBackgroundColor(Color.RED);
        }
    }

    public void onSubmitButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(CheckWord.this, main_menu.class);
        startActivity(intent);
    }
}