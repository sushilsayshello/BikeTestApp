package com.example.bike_test;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddBicycle(View view) {
        Intent i = new Intent(this, AddBicycleActivity.class);
        startActivity(i);
    }

    public void CheckBicycle(View view) {
        Intent i = new Intent(this, CheckBicycleActivity.class);
        startActivity(i);
    }

}
