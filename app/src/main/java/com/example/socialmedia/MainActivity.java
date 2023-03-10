package com.example.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.bibliotheque.model.User;
import com.example.socialmedia.model2.*;

import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import com.example.socialmedia.model2.User;

public class MainActivity extends AppCompatActivity {
TextView Sign_up;
EditText email,password,confirm_password;
 Button button_register;
 TextView rediraction;
 //UserHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_700)));

        button_register=findViewById(R.id.register);
        email=findViewById(R.id.emailregister);
        password=findViewById(R.id.password_register);
        confirm_password=findViewById(R.id.c_pass);

        //DB=new UserHelper(this);
        DatabaseHelper db=new DatabaseHelper(this);
        View.OnClickListener expres=(v)->{
            if(isoneofthefieldsempty())
                Toast.makeText(this,"missing information",Toast.LENGTH_LONG).show();
            else if(!isEmailwellwritten())
                Toast.makeText(this,"incorrect email",Toast.LENGTH_LONG).show();
            else if(!is_confirm_password_correct())
                Toast.makeText(this,"Incorrect Password",Toast.LENGTH_LONG).show();
            else {

                User user = new User();
                user.setEmail(email.getText().toString().toLowerCase(Locale.ROOT));
                user.setPassword(password.getText().toString());
                if (db.checkUser(user.getEmail()))
                    Toast.makeText(this, "this user already exist", Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(this, "succes", Toast.LENGTH_LONG).show();

                    db.addUser(user);
                    Intent intent = new Intent(this, home.class);
                    intent.putExtra("email", user.getEmail());
                    startActivity(intent);
                }
            }
        };
        button_register.setOnClickListener(expres);

    }
    public boolean isoneofthefieldsempty(){
       return (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()|| confirm_password.getText().toString().isEmpty());

    }
    public boolean is_confirm_password_correct(){
        return password.getText().toString().equals(confirm_password.getText().toString());
    }
    public boolean isEmailwellwritten(){
        return Pattern.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",email.getText().toString().trim());
    }
}