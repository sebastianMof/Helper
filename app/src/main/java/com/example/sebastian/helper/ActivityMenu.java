package com.example.sebastian.helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        configureNextButtonTrabajos();
        configureNextButtonEstudios();
        configureNextButtonPerfil();

    }
    private void configureNextButtonTrabajos() {
        Button nextButton = (Button)findViewById(R.id.buttontrabajo);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMenu.this, ActivityTrabajo.class));
            }
        });
    }
    private void configureNextButtonEstudios() {
        Button nextButton = (Button)findViewById(R.id.buttonestudio);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMenu.this, ActivityEstudio.class));
            }
        });
    }
    private void configureNextButtonPerfil() {
        Button nextButton = (Button)findViewById(R.id.buttonperfil);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMenu.this, Perfilis.class));
            }
        });
    }

}