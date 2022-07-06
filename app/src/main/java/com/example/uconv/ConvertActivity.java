package com.example.uconv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertActivity extends AppCompatActivity {
    Spinner spinnerOrigin, spinnerDestination;
    TextView result;
    EditText input;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        spinnerOrigin = findViewById(R.id.spinnerOrigin);
        spinnerDestination = findViewById(R.id.spinnerDestination);
        result = findViewById(R.id.result);
        input = findViewById(R.id.input);
        calculate = findViewById(R.id.calculate);
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        ArrayList<String> selectedUnits = extra.getStringArrayList("extraUnits");
        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, selectedUnits);
        spinAdapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        spinnerOrigin.setAdapter(spinAdapter);
        spinnerDestination.setAdapter(spinAdapter);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempInput = input.getText().toString();
                if(tempInput.isEmpty()){
                    Toast.makeText(ConvertActivity.this, "ERROR: PLEASE PROVIDE AN INPUT!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(spinnerOrigin.getSelectedItem().equals("Kilometer")) {
                        if (spinnerDestination.getSelectedItem().equals("Kilometer")) {
                            result.setText(tempInput);
                        } else if (spinnerDestination.getSelectedItem().equals("Meter")) {
                            result.setText(KilometerToMeter(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Decimeter")) {
                            result.setText(KilometerToDecimeter(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Centimeter")) {
                            result.setText(KilometerToCentimeter(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Millimeter")) {
                            result.setText(KilometerToMillimeter(Double.parseDouble(tempInput)));
                        }
                    } else if(spinnerOrigin.getSelectedItem().equals("Meter")) {
                        if (spinnerDestination.getSelectedItem().equals("Meter")) {
                            result.setText(tempInput);
                        } else if (spinnerDestination.getSelectedItem().equals("Kilometer")) {
                            result.setText(MeterToKilometer(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Decimeter")) {
                            result.setText(MeterToDecimeter(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Centimeter")) {
                            result.setText(MeterToCentimeter(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Millimeter")) {
                            result.setText(MeterToMillimeter(Double.parseDouble(tempInput)));
                        }
                    } else if(spinnerOrigin.getSelectedItem().equals("Decimeter")) {
                        if(spinnerDestination.getSelectedItem().equals("Decimeter")) {
                            result.setText(tempInput);
                        } else if (spinnerDestination.getSelectedItem().equals("Kilometer")) {
                            result.setText(DecimeterToKilometer(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Meter")) {
                            result.setText(DecimeterToMeter(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Centimeter")) {
                            result.setText(DecimeterToCentimeter(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Millimeter")) {
                            result.setText(DecimeterToMillimeter(Double.parseDouble(tempInput)));
                        }
                    } else if(spinnerOrigin.getSelectedItem().equals("Centimeter")) {
                        if(spinnerDestination.getSelectedItem().equals("Centimeter")) {
                            result.setText(tempInput);
                        } else if (spinnerDestination.getSelectedItem().equals("Kilometer")) {
                            result.setText(CentimeterToKilometer(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Meter")) {
                            result.setText(CentimeterToMeter(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Decimeter")) {
                            result.setText(CentimeterToDecimeter(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Millimeter")) {
                            result.setText(CentimeterToMillimeter(Double.parseDouble(tempInput)));
                        }
                    } else if(spinnerOrigin.getSelectedItem().equals("Millimeter")) {
                        if(spinnerDestination.getSelectedItem().equals("Millimeter")) {
                            result.setText(tempInput);
                        } else if (spinnerDestination.getSelectedItem().equals("Kilometer")) {
                            result.setText(MillimeterToKilometer(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Meter")) {
                            result.setText(MillimeterToMeter(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Decimeter")) {
                            result.setText(MillimeterToDecimeter(Double.parseDouble(tempInput)));
                        } else if (spinnerDestination.getSelectedItem().equals("Centimeter")) {
                            result.setText(MillimeterToCentimeter(Double.parseDouble(tempInput)));
                        }
                    }
                }
            }
        });
    }
    //Kilometer
    private String KilometerToMeter(double Kilometer) {
        double Meter = Kilometer * 1000;
        return String.valueOf(Meter);
    }
    private String KilometerToCentimeter(double Kilometer) {
        double Centimeter = Kilometer * 100000;
        return String.valueOf(Centimeter);
    }
    private String KilometerToDecimeter(double Kilometer) {
        double Decimeter = Kilometer * 100000;
        return String.valueOf(Decimeter);
    }
    private String KilometerToMillimeter(double Kilometer) {
        double Millimeter = Kilometer * 1000000;
        return String.valueOf(Millimeter);
    }
    //Meter
    private String MeterToKilometer(double Meter) {
        double Kilometer = Meter / 1000;
        return String.valueOf(Kilometer);
    }
    private String MeterToCentimeter(double Meter) {
        double Centimeter = Meter * 100;
        return String.valueOf(Centimeter);
    }
    private String MeterToDecimeter(double Meter) {
        double Decimeter = Meter * 10;
        return String.valueOf(Decimeter);
    }
    private String MeterToMillimeter(double Meter) {
        double Millimeter = Meter * 1000;
        return String.valueOf(Millimeter);
    }
    //Decimeter
    private String DecimeterToKilometer(double Decimeter) {
        double Kilometer = Decimeter / 10000;
        return String.valueOf(Kilometer);
    }
    private String DecimeterToMeter(double Decimeter) {
        double Meter = Decimeter / 10;
        return String.valueOf(Meter);
    }
    private String DecimeterToCentimeter(double Decimeter) {
        double Centimeter = Decimeter * 10;
        return String.valueOf(Centimeter);
    }
    private String DecimeterToMillimeter(double Decimeter) {
        double Millimeter = Decimeter * 100;
        return String.valueOf(Millimeter);
    }
    //Centimeter
    private String CentimeterToKilometer(double Centimeter) {
        double Kilometer = Centimeter / 100000;
        return String.valueOf(Kilometer);
    }
    private String CentimeterToMeter(double Centimeter) {
        double Meter = Centimeter / 100;
        return String.valueOf(Meter);
    }
    private String CentimeterToDecimeter(double Centimeter) {
        double Decimeter = Centimeter / 10;
        return String.valueOf(Decimeter);
    }
    private String CentimeterToMillimeter(double Centimeter) {
        double Millimeter = Centimeter * 10;
        return String.valueOf(Millimeter);
    }
    //Millimeter
    private String MillimeterToKilometer(double Millimeter) {
        double Kilometer = Millimeter / 1000000;
        return String.valueOf(Kilometer);
    }
    private String MillimeterToMeter(double Millimeter) {
        double Meter = Millimeter / 1000;
        return String.valueOf(Meter);
    }
    private String MillimeterToDecimeter(double Millimeter) {
        double Decimeter = Millimeter / 100;
        return String.valueOf(Decimeter);
    }
    private String MillimeterToCentimeter(double Millimeter) {
        double Centimeter = Millimeter / 10;
        return String.valueOf(Centimeter);
    }

}