package com.example.espino.manageproductrecycler.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.espino.manageproductrecycler.R;


public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout txiEmpresa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txiEmpresa = (TextInputLayout) findViewById(R.id.register_txi_enterprise);

    }

    public void mostrarTxi(View v){

        switch(v.getId()){

            case R.id.register_radiobtn_enterprise:
                txiEmpresa.setVisibility(View.VISIBLE);
                break;

            case R.id.register_radiobtn_person:
                txiEmpresa.setVisibility(View.INVISIBLE);
                break;
        }
    }
}
