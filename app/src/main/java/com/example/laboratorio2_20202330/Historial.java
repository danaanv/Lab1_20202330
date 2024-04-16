package com.example.laboratorio2_20202330;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historial);

        Toolbar toolbar2 = findViewById(R.id.toolbarhistorial);
        ImageButton imageButtonFlecha = toolbar2.findViewById(R.id.imageButtonFlecha);

        imageButtonFlecha.setOnClickListener(v -> {
            Intent intent = new Intent(Historial.this, Calcular.class);
            startActivity(intent);
        });

        TextView historialTexto = findViewById(R.id.historialTexto);

        ArrayList<String> resultList = getIntent().getStringArrayListExtra("numbersList");

        if (resultList != null && !resultList.isEmpty()) {
            int i = 1;
            String texto = historialTexto.getText().toString();

            // Iterar sobre la lista de resultados y mostrarlos en el TextView
            for (String resultado : resultList) {
                texto += "Resultado " + i + ": " + resultado + "\n";
                i++;
            }

            historialTexto.setText(texto);
        }

    }
}