package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.method.LinkMovementMethod;
import androidx.annotation.Nullable;
public class
LoginActivity extends AppCompatActivity {

    EditText edUsername,edPassword;
    Button btn;
    TextView tv,textFAQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupHyperlink();

        edUsername=findViewById(R.id.editTextLoginUsername);
        edPassword=findViewById(R.id.editTextLoginPassword);
        btn=findViewById(R.id.buttonLogin);
        tv=findViewById(R.id.textViewNewUser);
        textFAQ=findViewById(R.id.TextViewFAQ);



        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //startActivity(new Intent(LoginActivity.this,HomeActivity.class));//if login successful go to home activity
                String username=edUsername.getText().toString();
                String password=edPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if(username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(),"Please Fill All Details",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(db.login(username,password)==1) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();//if the values is 1 (record found)

                        //load the data to local memory(small memory) called as shared preferences
                        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("username",username);
                        //to save our data key and value
                        editor.apply();

                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));//if login successful go to home activity
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                        //CHECK
                        //startActivity(new Intent(LoginActivity.this,HomeActivity.class));//if login successful go to home activity
                    }
                }

            }
        });

        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                startActivity(new Intent(LoginActivity.this,RegiterActivity.class));

            }
        });

        textFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,EmailActivity.class));
            }
        });

        textFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,EmailActivity.class));
            }
        });


    }
    private void setupHyperlink() {
        TextView linkTextView = findViewById(R.id.activity_main_link);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}//