package com.example.espino.manageproduct;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;


public class ListProduct_activity extends ListActivity {

    private ProductAdapterA adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_activity);

        adapter = new ProductAdapterA(this);
        getListView().setAdapter(adapter);
    }

    public void onClick(View v){

    }


}
