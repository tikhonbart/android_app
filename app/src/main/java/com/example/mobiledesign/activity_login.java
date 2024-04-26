package com.example.mobiledesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.text.TextWatcher;
import android.text.Editable;


import com.example.mobiledesign.ui.main.ActivityLoginFragment;

public class activity_login extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_login);

        // Находим текстовые поля и кнопку в макете
        editText1 = findViewById(R.id.email);
        editText2 = findViewById(R.id.password);
        submitButton = findViewById(R.id.login);

        // По умолчанию делаем кнопку неактивной
        submitButton.setEnabled(false);

        // Добавляем слушатели изменений в текстовые поля
        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);
    }

    public void onbackButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(activity_login.this, MainActivity3.class);
        startActivity(intent);
    }

    public void onsignUpClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(activity_login.this, signup_activity.class);
        startActivity(intent);
    }

    public void onloginButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(activity_login.this, lan_choice.class);
        startActivity(intent);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            // Проверяем, заполнены ли оба текстовых поля
            boolean fieldsNotEmpty = editText1.getText().toString().trim().length() > 0 &&
                    editText2.getText().toString().trim().length() > 0;
            // Активируем кнопку, если оба текстовых поля заполнены, иначе деактивируем
            submitButton.setEnabled(fieldsNotEmpty);
        }
    };

}