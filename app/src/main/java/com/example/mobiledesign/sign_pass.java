package com.example.mobiledesign;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class sign_pass extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_pass);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Находим текстовые поля и кнопку в макете
        editText1 = findViewById(R.id.pass1);
        editText2 = findViewById(R.id.pass2);
        submitButton = findViewById(R.id.login);

        // По умолчанию делаем кнопку неактивной
        submitButton.setEnabled(false);

        // Добавляем слушатели изменений в текстовые поля
        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);



    }

    public void onClickSignUp(View view) {
        try {
            if (editText1.getText().toString().equals(editText2.getText().toString())) {
                Intent i = new Intent(sign_pass.this, main_menu.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception exception){
            Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
        }
    }

    public void onbackButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(sign_pass.this, activity_login.class);
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