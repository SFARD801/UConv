package com.example.uconv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] units = new String[]{"Kilometer","Meter","Centimeter","Decimeter","Millimeter"};
    ListView unitList;
    Button proceed, reset;
    TextView tv_1, tv_2;
    int selectedCount = 0;
    boolean permission = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unitList = findViewById(R.id.unitList);
        proceed = findViewById(R.id.proceed);
        reset = findViewById(R.id.reset);
        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, units);
        unitList.setAdapter(unitAdapter);
//        unitList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        unitList.setItemsCanFocus(false);
        //an array of selected items to further use in intent
        ArrayList<String> selectedUnits = new ArrayList<>(1);
        unitList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, (String) adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
                final String item = (String) adapterView.getItemAtPosition(i);
                if(selectedCount<=1) {
                    selectedUnits.add(item);
                    if(permission) {
                        tv_1.setText(item);
                        permission=false;
                    }
                    else
                        tv_2.setText(item);
                    selectedCount++;
                }
                else {
                    Toast.makeText(MainActivity.this, "Error: MAX SELECTED ITEMS = 2", Toast.LENGTH_SHORT).show();
                    String allItems = ""; //used to display in the toast

                    for(String str : selectedUnits){
                        allItems = allItems + "\t" + str;
                    }

                    Toast.makeText(getApplicationContext(),allItems, Toast.LENGTH_LONG).show();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedCount=0;
                selectedUnits.clear();
                permission=true;
                tv_1.setText("");
                tv_2.setText("");
            }
        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedCount<2){
                    Toast.makeText(MainActivity.this, "ERROR: PLEASE SELECT 2 ITEMS!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, ConvertActivity.class);
                    intent.putExtra("extraUnits", selectedUnits);
                    startActivity(intent);
                }
            }
        });
    }
}