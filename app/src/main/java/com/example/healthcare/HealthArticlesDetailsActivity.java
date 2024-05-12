package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticlesDetailsActivity extends AppCompatActivity {
TextView tv1;
ImageView img;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_details);
        btn=findViewById(R.id.buttonHealthDetailsBack);
        tv1=findViewById(R.id.textViewHealthDetailsArticlesTitle2);
        img=findViewById(R.id.imageView);

        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            int resId=bundle.getInt("text2");
            img.setImageResource(resId);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticlesDetailsActivity.this,HealthArticlesActivity.class));
            }
        });

    }
}