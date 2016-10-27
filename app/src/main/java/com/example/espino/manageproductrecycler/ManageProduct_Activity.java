package com.example.espino.manageproductrecycler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.espino.manageproductrecycler.Modelo.Product;

import java.util.List;


public class ManageProduct_Activity extends AppCompatActivity {

    private EditText mName,mDescription,mDossage,mBrand,mPrice,mStock,mImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product);

        mName = (EditText) findViewById(R.id.nameEdt);
        mDescription = (EditText) findViewById(R.id.editDescription);
        mDossage = (EditText) findViewById(R.id.dossageEdt);
        mBrand = (EditText) findViewById(R.id.brandEdt);
        mPrice = (EditText) findViewById(R.id.editPrice);
        mStock = (EditText) findViewById(R.id.stockEdt);
        mImage = (EditText) findViewById(R.id.imageEdt);


    }

    public void addProduct(View v){

       /* Product p = new Product(mName.getText().toString(),
                mDescription.getText().toString(),
                mDossage.getText().toString(),
                mBrand.getText().toString(),
                Double.parseDouble(mPrice.getText().toString()),
                Integer.parseInt(mStock.getText().toString()),
                R.drawable.medicamento);
*/
        Bundle b = new Bundle();
        b.putString("name",mName.getText().toString());
        b.putString("description",mDescription.getText().toString());
        b.putString("dossage",mDossage.getText().toString());
        b.putString("brand",mBrand.getText().toString());
        b.putString("price",mPrice.getText().toString());
        b.putString("stock",mStock.getText().toString());
        b.putString("image",mImage.getText().toString());

        //((ProductApplication)getApplicationContext()).saveProduct(p);

        Intent returnIntent = new Intent();
        returnIntent.putExtras(b);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

}
