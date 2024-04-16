package com.example.laboratorio2_20202330;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Indicaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_indicaciones);

        Button buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(v -> {
            Intent intent = new Intent(Indicaciones.this, Calcular.class);
            startActivity(intent);
        });

        Toolbar toolbar = findViewById(R.id.toolbardespues);
        ImageButton imageButtonFlecha = toolbar.findViewById(R.id.imageButtonFlecha);

        imageButtonFlecha.setOnClickListener(v -> {
            Intent intent = new Intent(Indicaciones.this, MainActivity.class);
            startActivity(intent);
        });

    }
}