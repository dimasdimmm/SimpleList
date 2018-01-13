package com.dimaspurwadi.simplelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    //use camelcase
    String trueUsername = "dimaspurwadi";
    String truePassword = "admin";


    //deklarasi variabel
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        //get value from input text
        String user = username.getText().toString();
        String pass = password.getText().toString();

        //validasi user dan password
        if (user.equals(trueUsername) && pass.equals(truePassword)) {
            Toast.makeText(this, "Username and password true", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            resetFormInput();
            startActivity(intent);
            finish();
        } else {
            resetFormInput();
            Toast.makeText(this, "Username and password true,try again", Toast.LENGTH_SHORT).show();
        }
    }

    void resetFormInput() {
        username.setText("");
        password.setText("");

        username.requestFocus();
    }
}
