package com.example.healthcare;

import static com.example.healthcare.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_find_doctor);

        CardView exit=findViewById(id.cardFDExit);
        exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });

        CardView familyphysician=findViewById(id.cardFDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Family Physician");
                startActivity(it);
            }
        });

        CardView dietician=findViewById(id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dieticians");
                startActivity(it);
            }
        });

        CardView dentist=findViewById(id.cardFDentist);
        dentist.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });

        CardView surgeon=findViewById(id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
            }
        });

        CardView cardiologist=findViewById(id.cardFDCardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);
            }
        });

    }
}