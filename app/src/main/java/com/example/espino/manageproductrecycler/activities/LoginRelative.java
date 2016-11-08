package com.example.espino.manageproductrecycler.activities;


import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.espino.manageproductrecycler.ProductApplication;
import com.example.espino.manageproductrecycler.R;
import com.example.espino.manageproductrecycler.interfaces.IloginMVP;
import com.example.espino.manageproductrecycler.presenters.LoginPresenter;


public class LoginRelative extends AppCompatActivity implements IloginMVP.View{

    private IloginMVP.Presenter loginMVP;
    private EditText edtPwd;
    private EditText edtUser;
    private TextInputLayout txiUser;
    private TextInputLayout txiPwd;
    private Button btnOk;
    private CheckBox chkRemenber;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginMVP = new LoginPresenter(this);
        edtUser = (EditText)findViewById(R.id.editUser);
        edtPwd = (EditText)findViewById(R.id.editPasswd);
        btnOk = (Button)findViewById(R.id.btnOK);
        txiUser = (TextInputLayout)findViewById(R.id.in1);
        txiPwd = (TextInputLayout)findViewById(R.id.in2);


        edtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txiUser.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        edtPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txiPwd.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginMVP.validateCredentials(edtPwd.getText().toString(), edtUser.getText().toString());
            }
        });

        if(((ProductApplication)getApplicationContext()).getUser() != null){
            Log.d(TAG,((ProductApplication)getApplicationContext()).getUser().toString());

        }


    }

    @Override
    public void setMessage(String msg, int idView) {

        switch (idView){
            case R.id.editUser:
                txiUser.setError(msg);
                edtUser.requestFocus();
                break;
            case  R.id.editPasswd:
                txiPwd.setError(msg);
                edtPwd.requestFocus();
                break;
            default:
                Toast.makeText(LoginRelative.this, R.string.ok, Toast.LENGTH_LONG).show();
                startActivity(new Intent(LoginRelative.this,Product_activity.class));
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(((ProductApplication)getApplicationContext()).getUser() != null){
            Log.d(TAG,((ProductApplication)getApplicationContext()).getUser().toString());

        }

    }

    public void register(View v){
        startActivity(new Intent(LoginRelative.this, RegisterActivity.class));
    }
}