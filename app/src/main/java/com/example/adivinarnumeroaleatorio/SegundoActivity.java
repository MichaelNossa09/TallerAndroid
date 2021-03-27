package com.example.adivinarnumeroaleatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    private EditText numero;
    private Button verificar,reiniciar;
    private TextView mensaje;
    private int aleatorio;
    private int intentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        String dato = getIntent().getStringExtra("dato");
        intentos = Integer.parseInt(dato);
        numero=(EditText)findViewById(R.id.txt_numero);
        verificar=(Button)findViewById(R.id.btnVerificar);
        reiniciar=(Button)findViewById(R.id.btnReiniciar);
        reiniciar.setEnabled(false);
        mensaje=(TextView)findViewById(R.id.txtMensaje);
        aleatorio=generarAleatorio();
        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numeroUsuario;
                numeroUsuario = Integer.parseInt(numero.getText().toString());
                if(aleatorio==numeroUsuario){
                    mensaje.setText("Has Ganado");
                    reiniciar.setEnabled(true);
                    verificar.setEnabled(false);
                }else if(aleatorio>numeroUsuario){
                    mensaje.setText("El numero a adivinar es Mayor");
                    intentos--;
                    numero.setText("");
                }else{
                    mensaje.setText("El numero a adivinar es Menor");
                    intentos--;
                    numero.setText("");
                }
                if(intentos==0){
                    mensaje.setText("HAS PERDIDO, NO TE QUEDAN MAS INTENTOS\nEl numero era: "+aleatorio);
                    numero.setText("");
                    verificar.setEnabled(false);
                    reiniciar.setEnabled(true);
                }
            }
        });
    }
    private int generarAleatorio(){
        return (int)(Math.random()*100+1);
    }
    public void reiniciar(View view){
       Intent anterior = new Intent(this,MainActivity.class);
       startActivity(anterior);
    }
}