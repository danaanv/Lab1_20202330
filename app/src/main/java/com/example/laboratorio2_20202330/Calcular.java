package com.example.laboratorio2_20202330;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class Calcular extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    ArrayList<String> numbersList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcular);

        Toolbar toolbar2 = findViewById(R.id.toolbarhistorial);
        ImageButton imageButtonFlecha2 = toolbar2.findViewById(R.id.imageButtonFlecha2);

        imageButtonFlecha2.setOnClickListener(v -> {
            Intent intent = new Intent(Calcular.this, MainActivity.class);
            startActivity(intent);
        });

        ImageButton imageButtonHistorial = toolbar2.findViewById(R.id.imageButtonHistorial);

        imageButtonHistorial.setOnClickListener(v -> {
            Intent intent = new Intent(Calcular.this, Historial.class);
            intent.putStringArrayListExtra("numbersList", numbersList);
            startActivity(intent);
        });

        textView1 = findViewById(R.id.textViewA);
        textView2 = findViewById(R.id.textViewB);
        textView3 = findViewById(R.id.textViewC);
    }

    private boolean isNewInput = true;
    private double operand1 = 0;
    private String operator = "";
    private String vez = "primera";
    private boolean validador = false;

    public void onNumberButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String currentText = textView3.getText().toString();

        if (vez == "primera"){
            operand1 = 0;
            operand2 = 0;
            String newText = currentText + buttonText;
            textView3.setText(newText);
        }else if(vez == "segunda"){
            String unido = textView3.getText().toString() + textView2.getText().toString();
            textView2.setText("");
            textView3.setText("");
            textView1.setText(unido);
            validador = true;
        }else if(vez == "limpieza"){
            if (textView2.getText().toString() == "0") {
                textView2.setText("");
            }
            textView3.setText("");
            String numero = textView2.getText().toString() + buttonText;
            textView2.setText(numero);
        }else if(vez == "proximas"){
            textView2.setText("");
            textView3.setText("");
            textView1.setText("");
            String newText = currentText + buttonText;
            textView3.setText(newText);
            vez = "primera";
        }
        if(validador){
            String currentText2 = textView2.getText().toString();
            String newText2 = currentText2 + buttonText;
            textView2.setText(newText2);
            vez = "hola";
            validador = true;
        }
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getTag().toString();
        operand1 = Double.parseDouble(textView3.getText().toString());
        textView2.setText(operator);
        vez = "segunda";
        validador = true;
        validador2 = false;
    }

    double operand2;
    boolean validador2 = false; // Para borrar historial
    public void onEqualsClick(View view) {
        operand2 = Double.parseDouble(textView2.getText().toString());
        double result = 0;
        int hola = 0;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    textView1.setText("Error");
                    textView2.setText("");
                    textView3.setText("");
                    vez = "primera";
                    validador = false;
                    hola = 1;
                    break;
                }
                break;
        }
        if(hola == 0){
            if(!validador2){
                numbersList.add(String.valueOf(result));
            }
            textView1.setText("0");
            textView3.setText("");
            textView2.setText(String.valueOf(result));
            isNewInput = true;
            operand1 = result;
            operator = "";
            validador = false;
            vez = "proximas";
        }
    }

    public void onClearClick(View view) {
        textView3.setText("");
        textView2.setText("0");
        operand2 = 0;
        validador = false;
        vez = "limpieza";
        validador2 = true;
    }
}