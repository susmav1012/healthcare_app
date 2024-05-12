package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages= {
            {"Uprise-03 1000IU Capsule", "", "", "", "50"},
            {"HealthVit chromium Capsule", "", "", "", "305"},
            {"Vitamin E Wheat germ oil capusle", "", "", "", "448"},
            {"Vitamin B capsule", "", "", "", "539"},
            {"Crocin 650 advance Tablet", "", "", "", "30"},
            {"Strepsils Tablet", "", "", "", "50"},
            {"Dolo 3-g", "", "", "", "40"},
            {"Tata 1mg calcium tablet", "", "", "", "30"},
            {"Feronia -XT Tablet", "", "", "", "130"},
    };
    private String[] package_details={
      "Building and keeping bones and teeth strong\n"+
      "Reducing fatigue and muscle pains\n"+
      "Boosting immunity and increasing resistance against infection",

      "Chromium is essential in our daily life\n"+
              "Chromium acts as a immune to us",


            "It promotes skin as well as health benefits\n"+
                    "It reduces skin pigmentation\n"+
                    "It acts as a safe guard forUVB sun rays",

            "Provides relief from Vitamin B deficiencies\n"+
                    "Helps in formation of RBC cells\n"+
                    "Maintains nervous systems",

            "Helps releive pain and fever by blocking the release of certain chemical mechanism\n"+
                    "Helps relieve high fever and headache",

            "relieves the pain of throat and used for throat infection\n"+
            "Provides a warm and comforting feeling during sore throat",

            "Helps releive pain and fever by blocking the release of certain chemical mechanism\n"+
                    "Helps relieve high fever and headache",

            "Reduces risk of calcium deficiency\n"+
            "Promotes mobility and flexibiity of joints",

            "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"

    };

    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;

    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

       // lst=findViewById(R.id.listViewBM);
        btnBack=findViewById(R.id.buttonbuymedBack);
        btnGoToCart=findViewById(R.id.buttonbuymedAddtocart);



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5",packages[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

                ListView lst=findViewById(R.id.listViewBM);
                lst.setAdapter(sa);

                 lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                 @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent it=new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                        it.putExtra("text1",packages[i][0]);
                        it.putExtra("text2",package_details[i]);
                        it.putExtra("text3",packages[i][4]);
                        startActivity(it);
                }
            });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });



    }
}