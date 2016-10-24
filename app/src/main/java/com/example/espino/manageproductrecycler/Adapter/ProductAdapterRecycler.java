package com.example.espino.manageproductrecycler.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.espino.manageproductrecycler.Modelo.Product;
import com.example.espino.manageproductrecycler.ProductApplication;
import com.example.espino.manageproductrecycler.R;

import java.util.List;


public class ProductAdapterRecycler extends RecyclerView.Adapter<ProductAdapterRecycler.ProductViewHolder>{

    private List<Product> products;
    private Context context;

    public ProductAdapterRecycler(Context context) {
        this.context = context;
        products = ((ProductApplication)context.getApplicationContext()).getProductList();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //1.Crear un objeto inflater que inicializamos al layoutInlater del contexto
       View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item, parent);


        return new ProductViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        //4.Asignar datos del adapter a los widget
        holder.img.setImageResource(products.get(position).getmImage());
        holder.nameTxt.setText(products.get(position).getmName());
        holder.stockTxt.setText(products.get(position).getFormattedUnitsinStocks());


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    //Creamos la clase estática porque proporciona la misma funcionalidad a todos los objetos
    //y al ser estática será mas rápida la inicialización porque solo habrá una clase view holder
    public static class  ProductViewHolder extends RecyclerView.ViewHolder{

        private TextView stockTxt, nameTxt;
        private ImageView img;

        public ProductViewHolder(View item){
            super(item);
            //3.Asignar a las variables los widget mediante el metodo findviewbyid
            img = (ImageView) item.findViewById(R.id.img);
            nameTxt = (TextView) item.findViewById(R.id.nombre);
            stockTxt = (TextView) item.findViewById(R.id.marca);
        }
    }

}
