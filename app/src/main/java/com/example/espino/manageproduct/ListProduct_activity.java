package com.example.espino.manageproduct;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.espino.manageproduct.Modelo.Product;


public class ListProduct_activity extends ListActivity {

    private ProductAdapterB adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_activity);

        adapter = new ProductAdapterB(this);
        getListView().setAdapter(adapter);
    }

    public void onClick(View v){
        startActivityForResult(new Intent(ListProduct_activity.this,AddProduct_Activity.class),0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle b = new Bundle(data.getExtras());
        Product p = new Product(b.getString("name"),
                b.getString("description"),
                b.getString("dossage"),
                b.getString("brand"),
                Double.parseDouble(b.getString("price")),
                Integer.parseInt(b.getString("stock")),
                R.drawable.medicamento);


        adapter.add(p);


    }
}
