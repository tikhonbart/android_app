package com.example.mobiledesign;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import android.view.View;
import android.widget.EditText;

import androidx.core.view.WindowInsetsCompat;

public class animal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtanswer = findViewById(R.id.editTextText);

        // Установить обработчик события для проверки введенного слова
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получить введенное слово из TextInputEditText
                String userInput = txtanswer.getText().toString().trim();

                String targetWord = "hamster";

                if (userInput.equalsIgnoreCase(targetWord)) {
                    Intent intent = new Intent(animal.this, rightAnimal.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(animal.this, wrongAnimal.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void onbackButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(animal.this, main_menu.class);
        startActivity(intent);
    }


}