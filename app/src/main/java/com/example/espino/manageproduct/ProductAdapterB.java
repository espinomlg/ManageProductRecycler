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

public class ProductAdapterB extends ArrayAdapter<Product> {

    private Context context;

    public ProductAdapterB(Context context) {
        super(context, R.layout.activity_add_product, ((ProductApplication)context.getApplicationContext()).getProductList());
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //4 pasos:
        View item = convertView;
        ProductHolder productHolder;
        //   TextView priceTxt;

        //evitamos inflarlo si el item ya está en memoria
        if(item == null) {
            //1.Crear un objeto inflater que inicializamos al layoutInlater del contexto
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());

            //2.Inflar la vista y crear en memoria el objeto view que contiene los widget del XML
            item = layoutInflater.inflate(R.layout.activity_list_item, null);
            productHolder = new ProductHolder();

        //3.Asignar a las variables los widget mediante el metodo findviewbyid
            productHolder.img = (ImageView) item.findViewById(R.id.img);
            productHolder.nameTxt = (TextView) item.findViewById(R.id.nombre);
            productHolder.stockTxt = (TextView) item.findViewById(R.id.marca);

            item.setTag(productHolder);

        }else {
            productHolder = (ProductHolder) item.getTag();
        }
            //4.Asignar datos del adapter a los widget
            productHolder.img.setImageResource(getItem(position).getmImage());
            productHolder.nameTxt.setText(getItem(position).getmName());
            productHolder.stockTxt.setText(getItem(position).getFormattedUnitsinStocks());


        if(position % 2 != 0)
            item.setBackgroundResource(R.color.colorPrimaryDark);
        else
            item.setBackgroundResource(R.color.colorPrimary);

        return item;
    }

    /**
     * Clase interna que contiene los widget del XML
     * */
    class ProductHolder{

        ImageView img;
        TextView nameTxt;
        TextView stockTxt;

    }
}
