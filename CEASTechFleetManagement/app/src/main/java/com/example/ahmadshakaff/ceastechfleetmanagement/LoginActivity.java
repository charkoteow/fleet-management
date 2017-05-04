package com.example.ahmadshakaff.ceastechfleetmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameTxt,passwordTxt;
    Button loginBtn;
    CheckBox remChk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTxt= (EditText)findViewById(R.id.usernameTxt);
        passwordTxt=(EditText)findViewById(R.id.passwdTxt);
        loginBtn=(Button)findViewById(R.id.LoginBtn);
        remChk=(CheckBox)findViewById(R.id.remPasswdChk);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                if(login(usernameTxt.getText().toString(),passwordTxt.getText().toString())==1){
                    Toast.makeText(getApplicationContext(),"Logged In!", Toast.LENGTH_LONG).show();
                    if(!(remChk.isChecked())){
                        passwordTxt.setText("");
                    }

                    usernameTxt.setText("");

                    //Start Dashboard
                    startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Please Enter The Correct Details!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //TODO Proper Login Method
    private int login(String name, String password)
    {
        if(name.isEmpty() || password.isEmpty()){
                return 0;
        }
        else if(name.equals("Admin") && password.equals("1234")){
            return 1;
        }
        return 0;
    }
}
