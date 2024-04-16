package com.example.laboratorio2_20202330;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button buttonIndicaciones = findViewById(R.id.buttonIndicaciones);
        buttonIndicaciones.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Indicaciones.class);
            startActivity(intent);
        });

        Button buttonCalcular = findViewById(R.id.buttonCalcular1);
        buttonCalcular.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Calcular.class);
            startActivity(intent);
        });

        TextView telemath = findViewById(R.id.telemath);
        registerForContextMenu(telemath);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_item_red){
            cambiarColorBoton(Color.RED);
            return true;
        }else if(id == R.id.menu_item_green){
            cambiarColorBoton(Color.GREEN);
            return true;
        }else if (id == R.id.menu_item_blue){
            cambiarColorBoton(Color.BLUE);
            return true;
        }else {
            return super.onContextItemSelected(item);
        }
    }

    private void cambiarColorBoton(int color) {
        TextView telemath = findViewById(R.id.telemath);
        telemath.setTextColor(color);
    }

}
