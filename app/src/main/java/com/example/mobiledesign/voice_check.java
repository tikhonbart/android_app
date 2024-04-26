package com.example.mobiledesign;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import android.widget.EditText;
import android.widget.ImageButton;
import android.media.MediaRecorder;

import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class voice_check extends AppCompatActivity {
    private MediaRecorder mediaRecorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_voice_check);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void startRecording(View view) {
        String filePath = getExternalCacheDir().getAbsolutePath() + "/audio.3gp";
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setOutputFile(filePath);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopRecording() {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
    }

    // Вызывается при завершении записи, например, по нажатию на другую кнопку
    private void finishRecording() {
        stopRecording();
        // Передаем путь к файлу с записанным аудио в следующую активность
        Intent intent = new Intent(voice_check.this, voice_ans.class);
        String filePath = getExternalCacheDir().getAbsolutePath() + "/audio.3gp";
        intent.putExtra("RECORDED_AUDIO", filePath);
        startActivity(intent);
    }

    public void onbackButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(voice_check.this, main_menu.class);
        startActivity(intent);
    }
    public void onNextButtonClick(View view) {
        // Создаем интент для перехода на следующую активность
        Intent intent = new Intent(voice_check.this, voice_ans.class);
        startActivity(intent);
    }
}