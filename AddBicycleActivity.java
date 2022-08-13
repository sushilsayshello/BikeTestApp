package com.example.bike_test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBicycleActivity extends AppCompatActivity {

    DatabaseHelper shop;
    Button btn_insertData ;
    EditText ETbrand, ETmodel, ETcategory, ETprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bicycle);

        shop = new DatabaseHelper(this);
        btn_insertData = findViewById(R.id.AddBicycle);
        ETbrand = findViewById(R.id.bicycleBrandET);
        ETmodel = findViewById(R.id.bicycleModelET);
        ETcategory = findViewById(R.id.bicycleCategoryET);
        ETprice = findViewById(R.id.bicyclePriceET);

        btn_insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean duplicates = false;

                if (ETbrand.getText().toString().isEmpty() || ETmodel.getText().toString().isEmpty() || ETcategory.getText().toString().isEmpty() || ETprice.getText().toString().isEmpty()) {
                    Toast.makeText(AddBicycleActivity.this, "All fields must be entered.", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor cursor = shop.getAllData();
                    while (cursor.moveToNext()) {
                        if (ETbrand.getText().toString().equals(cursor.getString(0)) && ETmodel.getText().toString().equals(cursor.getString(1)) && ETcategory.getText().toString().equals(cursor.getString(2))) {
                            Toast.makeText(AddBicycleActivity.this, "This bicycle is already in the table.", Toast.LENGTH_SHORT).show();
                            duplicates = true;
                        }
                    }
                    if(!duplicates) {
                        boolean isinsert = shop.insertData(ETbrand.getText().toString(), ETmodel.getText().toString(), ETcategory.getText().toString(), ETprice.getText().toString());

                        if (isinsert == true) {
                            Toast.makeText(AddBicycleActivity.this, "added successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddBicycleActivity.this, "not been added", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                ETbrand.setText("");
                ETmodel.setText("");
                ETcategory.setText("");
                ETprice.setText("");
            }

        });
    }
}
