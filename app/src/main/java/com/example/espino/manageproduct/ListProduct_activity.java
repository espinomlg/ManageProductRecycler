package com.example.espino.manageproduct;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.espino.manageproduct.Modelo.Product;

import java.util.ArrayList;

public class ListProduct_activity extends ListActivity {


    private ArrayAdapter<Product> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_activity);

        adapter = new ArrayAdapter<Product>(this, android.R.layout.simple_expandable_list_item_1,((ProductApplication)getApplication()).getProductList());
        getListView().setAdapter(adapter);
    }


}
