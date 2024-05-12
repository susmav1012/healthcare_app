package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][]doctor_details1=
            {
                    {"Doctor Name: Ajay Varma","Hospital Address: NGGO Colony ","Experience: 3 years","Mobile NO.: 8799087689","300"},
                    {"Doctor Name: Saranya Vignesh","Hospital Address: Peelamedu ","Experience: 4years","Mobile NO.: 9908352611","350"},
                    {"Doctor Name: Vishal Sharma","Hospital Address: Sitra ","Experience: 10 years","Mobile NO.: 6789464737","400"},
                    {"Doctor Name: TamilSelvi","Hospital Address: Gandhipuram","Experience: 7 years","Mobile NO.: 9065784473","400"},
                    {"Doctor Name: Karun Nair","Hospital Address: Mettupalayam","Experience: 2 years","Mobile NO.: 9123543233","200"}
            };

    private String[][]doctor_details2=
            {
                    {"Doctor Name: Ajeesh","Hospital Address: Peelamedu ","Experience: 2 years","Mobile NO.: 9874556854","250"},
                    {"Doctor Name: Karthik","Hospital Address: Saibaba Colony ","Experience: 1years","Mobile NO.: 6588974458","100"},
                    {"Doctor Name: Vignesh","Hospital Address: Neelambur ","Experience: 17 years","Mobile NO.: 9874885698","900"},
                    {"Doctor Name: Tharaka Shri","Hospital Address: R.S Puram","Experience: 6 years","Mobile NO.: 9844578874","600"},
                    {"Doctor Name: Vimal Prakash","Hospital Address: Mettupalayam","Experience: 3 years","Mobile NO.: 8745887458","300"}
            };

    private String[][]doctor_details3=
            {
                    {"Doctor Name: Ajay Sharma","Hospital Address: Sitra ","Experience: 15 years","Mobile NO.: 9878858896","600"},
                    {"Doctor Name: Sharmila","Hospital Address: Town Hall ","Experience: 12 years","Mobile NO.: 9877458856","900"},
                    {"Doctor Name: Vikas Hooda","Hospital Address: Anna Street ","Experience: 1 years","Mobile NO.: 6988969896","100"},
                    {"Doctor Name: Akshay","Hospital Address: Mettupalayam","Experience: 2 years","Mobile NO.: 8577898745","200"},
                    {"Doctor Name: Amala","Hospital Address: Gandhipuram","Experience: 2 years","Mobile NO.: 9877859878","200"}
            };

    private String[][]doctor_details4=
            {
                    {"Doctor Name: Ashok","Hospital Address: Saibaba Colony ","Experience: 1 years","Mobile NO.: 6988787878","100"},
                    {"Doctor Name: Ravindhar","Hospital Address: Peelamedu ","Experience: 3 years","Mobile NO.: 8785856988","350"},
                    {"Doctor Name: Prakash","Hospital Address: NGGO Colony ","Experience: 5 years","Mobile NO.: 8745889689","500"},
                    {"Doctor Name: Baskaran","Hospital Address: Gandhipuram","Experience: 3 years","Mobile NO.: 6878787898","300"},
                    {"Doctor Name: Nikhila","Hospital Address: Sitra","Experience: 7 years","Mobile NO.: 8574698744","700"}
            };

    private String[][]doctor_details5=
            {
                    {"Doctor Name: JayaPrakash","Hospital Address: NGGO Colony ","Experience: 4 years","Mobile NO.: 9844561125","300"},
                    {"Doctor Name: Lokesh","Hospital Address: Peelamedu ","Experience: 12 years","Mobile NO.: 8633265411","600"},
                    {"Doctor Name: GowriKala","Hospital Address: Sitra ","Experience: 2 years","Mobile NO.: 8974568596","250"},
                    {"Doctor Name: Moorthi","Hospital Address: Mettupalayam","Experience: 14 years","Mobile NO.: 8977454485","700"},
                    {"Doctor Name: Dennis Skillwin","Hospital Address: Mettupalayam","Experience: 3 years","Mobile NO.: 8977456698","300"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonLDAddToCart);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
    list=new ArrayList();
    for(int i=0;i<doctor_details.length;i++)
    {
        item=new HashMap<String,String>();
        item.put("line1",doctor_details[i][0]);
        item.put("line2",doctor_details[i][1]);
        item.put("line3",doctor_details[i][2]);
        item.put("line4",doctor_details[i][3]);
        item.put("line5","Consultant Fees: "+doctor_details[i][4]+"/-");
        list.add( item );
    }
    sa=new SimpleAdapter(this,list,
            R.layout.multi_lines,
            new String []{"line1","line2","line3","line4","line5"},
            new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.listViewOD);
        lst.setAdapter(sa);

       lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
               it.putExtra("text1",title);
               it.putExtra("text2",doctor_details[i][0]);
               it.putExtra("text3",doctor_details[i][1]);
               it.putExtra("text4",doctor_details[i][3]);
               it.putExtra("text5",doctor_details[i][4]);
               startActivity(it);

           }
       });
    }
}