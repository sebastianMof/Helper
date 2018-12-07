package com.example.sebastian.helper;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityEstudio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudio);
        configureNextButtonHorario();
        configureNextButtonComu();
        configureNextButtonEve();
        configureNextButtonAnEve();
        configureNextButtonAnCont();

    }

    private void configureNextButtonHorario() {
        Button nextButton = (Button)findViewById(R.id.buttonHorario);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityEstudio.this, ActivityHorario.class));
            }
        });
    }

    private void configureNextButtonComu() {
        Button nextButton = (Button)findViewById(R.id.buttonComu);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityEstudio.this, ActivityComunidad.class));
            }
        });
    }

    private void configureNextButtonEve() {
        Button nextButton = (Button)findViewById(R.id.buttonEve);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityEstudio.this, ActivityEventoEstudio.class));
            }
        });
    }

    private void configureNextButtonAnEve() {
        Button nextButton = (Button)findViewById(R.id.buttonAnEve);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityEstudio.this, ActivityAnadirEvento.class));
            }
        });
    }

    private void configureNextButtonAnCont() {
        Button nextButton = (Button)findViewById(R.id.buttonPerf);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityEstudio.this, ActivityContacto.class));
            }
        });
    }



    public void openPortal(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://portal.udp.cl"));
        startActivity(browserIntent);
    }
    public void openFolder(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
                + "/storage/emulated/0/Download/");
        intent.setDataAndType(uri, "resource/folder");
        startActivity(Intent.createChooser(intent, "Open folder"));
    }

}
