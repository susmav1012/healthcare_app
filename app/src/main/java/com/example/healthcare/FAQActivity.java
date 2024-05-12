package com.example.healthcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.Manifest;

public class FAQActivity extends AppCompatActivity {
    EditText FAQmessage,FAQnumber;
    String phone;
    Button FAQSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqactivity);
        //phone="6385480548";
        FAQnumber=findViewById(R.id.FAQnumber);
        FAQmessage=findViewById(R.id.FAQmessage);
        FAQSend=findViewById(R.id.Send);

        FAQSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(FAQActivity.this
                        , Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED){
                    sendMessage();
                }else{
                    ActivityCompat.requestPermissions(FAQActivity.this,
                            new String[]{
                        Manifest.permission.SEND_SMS},100);
                }
            }
        });

    }

    private void sendMessage() {
        String sphn=FAQnumber.getText().toString().trim();
        String smsg=FAQmessage.getText().toString().trim();
        if(!sphn.equals("") && !smsg.equals(""))
        {
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(sphn,null,smsg,null,null);
            Toast.makeText(getApplicationContext(), "Sent successfully !",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Message cant be empty",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==100 && grantResults.length>0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
            sendMessage();
        }
        else{
            Toast.makeText(getApplicationContext(), "Permission Denied",Toast.LENGTH_SHORT).show();
        }



    }
}