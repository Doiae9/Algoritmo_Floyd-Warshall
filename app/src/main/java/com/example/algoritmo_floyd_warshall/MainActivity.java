package com.example.algoritmo_floyd_warshall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CaminosMinimos ruta = new CaminosMinimos();
        long matrizA [][]={{0,3,4,ruta.getInf(), 8, ruta.getInf()},
                {ruta.getInf(),0,ruta.getInf(), ruta.getInf(),5,ruta.getInf()},
        {ruta.getInf(),ruta.getInf(),0,ruta.getInf(),3,ruta.getInf()},
        {ruta.getInf(),ruta.getInf(),ruta.getInf(),0,3,ruta.getInf()},
        {ruta.getInf(),ruta.getInf(),ruta.getInf(),7,0,3},
        {ruta.getInf(),ruta.getInf(), ruta.getInf(), 2, ruta.getInf(),0}};

        //Log.i("log",ruta.algoritmoFloyd((matrizA)));
        System.out.println(ruta.algoritmoFloyd((matrizA)));
    }
}