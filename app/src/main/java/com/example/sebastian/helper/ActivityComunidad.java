package com.example.sebastian.helper;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityComunidad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunidad);
        configureNextButtonAnaForo();

        // Get reference of widgets from XML layout
        ListView lv = (ListView) findViewById(R.id.lv);

        // Initializing a new String Array
        String[] fruits = new String[] {
                "Calculo I",
                "Calculo II",
                "Calculo III",
                "Algebra y Geometria",
                "Algebra Lineal",
                "Ecuaciones Diferenciales",
                "Mecanica",
                "Calor y Ondas",
                "Electricidad y Magnetismo",
                "Progrmacion",
                "Progrmacion Avanzada",
                "Estructura de Datos"
        };

        // Create a List from String Array elements
        List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));

        // Create a ArrayAdapter from List
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, fruits_list);

        // Populate ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);

        // Set an item click listener for ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Display the selected item text on TextView
                //tv.setText("Your favorite : " + selectedItem);

                Intent intent = new Intent(getBaseContext(), ActivityForo.class);

                intent.putExtra("EXTRA_SESSION_ID", selectedItem);
                startActivity(intent);
            }
        });
    }

    private void configureNextButtonAnaForo() {
        Button nextButton = (Button)findViewById(R.id.anafor);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityComunidad.this, ActivityAnadirForo.class));
            }
        });
    }
}
