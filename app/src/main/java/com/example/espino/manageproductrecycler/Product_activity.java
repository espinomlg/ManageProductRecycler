package com.example.espino.manageproductrecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.espino.manageproductrecycler.Adapter.ProductAdapterRecycler;


public class Product_activity extends AppCompatActivity {

    private ProductAdapterRecycler adapter;
    private RecyclerView rcvProduct;
    private final static int ADD_PRODUCT = 0;
    private final static int EDIT_PRODUCT = 1;
    private boolean sort = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_activity);

        adapter = new ProductAdapterRecycler(this);
        rcvProduct= (RecyclerView) findViewById(R.id.rcvProduct);
        rcvProduct.setLayoutManager(new LinearLayoutManager(this));
        rcvProduct.setAdapter(adapter);
        //el viewGroup del adapter es el rcvProduct
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meu_product, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_add_product:
                Intent intent = new Intent(Product_activity.this, ManageProduct_Activity.class);
                startActivityForResult(intent, ADD_PRODUCT);

            case R.id.action_order_alphabetically:
                adapter.sortAlphabetically(sort);
                sort = !sort;
                break;

            case R.id.action_setting_general:
                break;

            case R.id.action_settings_account:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case ADD_PRODUCT:
            if(resultCode == RESULT_OK){

            }
                break;
            case EDIT_PRODUCT:
                break;
        }

    }





    /*
    public void onClick(View v){
        startActivityForResult(new Intent(Product_activity.this,ManageProduct_Activity.class),0);
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

    */
}
