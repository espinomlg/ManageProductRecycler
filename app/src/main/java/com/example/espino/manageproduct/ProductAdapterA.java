package com.example.espino.manageproduct;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.espino.manageproduct.Modelo.Product;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by espino on 21/10/16.
 */

public class ProductAdapterA extends ArrayAdapter<Product> {

    private Context context;

    public ProductAdapterA(Context context) {
        super(context, R.layout.activity_add_product, ((ProductApplication)context.getApplicationContext()).getProductList());
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //4 pasos:
        ImageView img;
        TextView nameTxt;
        TextView stockTxt;
     //   TextView priceTxt;

        //1.Crear un objeto inflater que inicializamos al layoutInlater del contexto
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        //2.Inflar la vista y crear en memoria el objeto view que contiene los widget del XML
        View item = layoutInflater.inflate(R.layout.activity_list_item, null);

        //3.Asignar a las variables los widget mediante el metodo findviewbyid
        img = (ImageView) item.findViewById(R.id.img);
        nameTxt = (TextView) item.findViewById(R.id.nombre);
        stockTxt = (TextView) item.findViewById(R.id.marca);

        //4.Asignar datos del adapter a los widget
        img.setImageResource(getItem(position).getmImage());
        nameTxt.setText(getItem(position).getmName());
        stockTxt.setText(getItem(position).getFormattedUnitsinStocks());


        return item;
    }
}
