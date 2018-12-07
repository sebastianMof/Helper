package com.example.sebastian.helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTrabajo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabajo);

        configureNextButtonProyectos();
        configureNextButtonTareas();
        configureNextButtonReuniones();

    }

    private void configureNextButtonProyectos() {
        Button nextButton = (Button)findViewById(R.id.buttonproyectos);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityTrabajo.this, ActivityProyecto.class));

            }
        });
    }
    private void configureNextButtonTareas() {
        Button nextButton = (Button)findViewById(R.id.buttontareas);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityTrabajo.this, ActivityTarea.class));

            }
        });
    }
    private void configureNextButtonReuniones() {
        Button nextButton = (Button)findViewById(R.id.buttonreuniones);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityTrabajo.this, ActivityReunion.class));

            }
        });
    }
}