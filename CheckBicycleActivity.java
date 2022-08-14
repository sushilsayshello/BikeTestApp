package com.example.bike_test;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckBicycleActivity extends AppCompatActivity {

    DatabaseHelper shop;
    Button btn_checkData ;
    EditText ETbrandCheck, ETmodelCheck, ETcategoryCheck;
    TextView TVpriceCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_bicycle);

        shop = new DatabaseHelper(this);
        btn_checkData = findViewById(R.id.Check_bicycleBtn);
        ETbrandCheck = findViewById(R.id.bicycleBrandET);
        ETmodelCheck = findViewById(R.id.bicycleModelET);
        ETcategoryCheck = findViewById(R.id.bicycleCategoryET);
        TVpriceCheck = findViewById(R.id.bicyclePriceTV);

        btn_checkData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor = shop.getAllData();
                TVpriceCheck.setText("Not found.");

                if (cursor.getCount() == 0) {
                    TVpriceCheck.setText("Database empty !");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                if (ETbrandCheck.getText().toString().isEmpty() || ETmodelCheck.getText().toString().isEmpty() || ETcategoryCheck.getText().toString().isEmpty()) {
                    Toast.makeText(CheckBicycleActivity.this, "Please enter all fields.", Toast.LENGTH_SHORT).show();
                }
                while (cursor.moveToNext()) {
                    if (ETbrandCheck.getText().toString().equals(cursor.getString(0)) && ETmodelCheck.getText().toString().equals(cursor.getString(1)) && ETcategoryCheck.getText().toString().equals(cursor.getString(2))) {

                        buffer.append("" + cursor.getString(3) + "\n");
                        TVpriceCheck.setText( buffer.toString());
                    }

                }
            }

        });

    }
}