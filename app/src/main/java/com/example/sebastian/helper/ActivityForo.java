package com.example.sebastian.helper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityForo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foro);

        String sessionId= getIntent().getStringExtra("EXTRA_SESSION_ID");

        // Get reference of widgets from XML layout
        ListView lv = (ListView) findViewById(R.id.listViewFor);

        // Initializing a new String Array
        String[] fruits = new String[30];


        int i = 0;
        while(i < 30){
            fruits[i] = "";

            i = i + 1;
        }

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        Cursor filatit = BaseDeDatos.rawQuery("SELECT titulo FROM FORO WHERE ramo = ?; ", new String[]{sessionId});

        i = 0;
        while(filatit.moveToNext()){
            fruits[i] = (filatit.getString(0));

            i = i + 1;
        }

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

                Intent intent = new Intent(getBaseContext(), ActivityForoInfo.class);

                intent.putExtra("EXTRA_SESSION_ID2", selectedItem);
                startActivity(intent);
            }
        });
    }
}
