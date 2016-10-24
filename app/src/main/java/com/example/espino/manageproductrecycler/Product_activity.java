package com.example.espino.manageproductrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.espino.manageproductrecycler.Adapter.ProductAdapterRecycler;


public class Product_activity extends AppCompatActivity {

    private ProductAdapterRecycler adapter;
    private RecyclerView rcvProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_activity);

        adapter = new ProductAdapterRecycler(this);
        rcvProduct= (RecyclerView) findViewById(R.id.rcvProduct);
        rcvProduct.setAdapter(adapter);
        //el viewGroup del adapter es el rcvProduct
    }

    /*
    public void onClick(View v){
        startActivityForResult(new Intent(Product_activity.this,AddProduct_Activity.class),0);
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
