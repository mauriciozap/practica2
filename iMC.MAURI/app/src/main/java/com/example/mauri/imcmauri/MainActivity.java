package com.example.mauri.imcmauri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText mCampoPeso;
    EditText mCampoEstatura;
    Button mBotonCalcular;
    Button mBotonLimpiar;
    TextView mEtiquetaImc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCampoPeso = (EditText) findViewById(R.id.campo_peso);
        mCampoEstatura = (EditText) findViewById(R.id.campo_estatura);
        mBotonCalcular = (Button) findViewById(R.id.boton_calcular);
        mBotonCalcular.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String s = mCampoPeso.getText().toString();
                double peso = Double.parseDouble(s);
                s = mCampoEstatura.getText().toString();
                double estatura = Double.parseDouble(s);
                double imc = peso / (estatura * estatura);
                s = String.format("%2.2f", imc);
                mEtiquetaImc.setText(s);
            }
        });

        mBotonLimpiar = (Button) findViewById(R.id.boton_limpiar);
        mBotonLimpiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mEtiquetaImc.setText("0.0");
            }
        });

        mEtiquetaImc = (TextView) findViewById(R.id.etiqueta_imc);
    }
}
