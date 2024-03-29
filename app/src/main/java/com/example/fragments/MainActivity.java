package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CarreraListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentListado fragmentListado =(FragmentListado)getSupportFragmentManager().findFragmentById(R.id.frgListado);
        fragmentListado.setCorreoListener(this);
    }

    @Override
    public void onCarreraSeleccionado(Carrera carrera) {
        boolean hayDetalle =(getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!= null);
        if (hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager()
                    .findFragmentById(R.id.frgDetalle)).mostrarDetalle(carrera.getCartel());
        }else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, carrera.getEdicion());
            startActivity(i);
        }
    }
}
