package com.example.adivinarnumeroaleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner intentos;
    private Button jugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentos = (Spinner)findViewById(R.id.spinner);

        String [] opciones = {"5", "7", "10"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        intentos.setAdapter(adapter);
    }

    public void jugar(View view){
        Intent siguiente = new Intent(this, SegundoActivity.class);
        String seleccion = intentos.getSelectedItem().toString();
        siguiente.putExtra("dato", seleccion);
        startActivity(siguiente);
    }
}