package com.example.espino.manageproductrecycler;

import android.app.Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.espino.manageproductrecycler.Modelo.Product;


public class ProductApplication extends Application {

    ArrayList<Product> productList;

    public void saveProduct(Product p){
        productList.add(p);
    }

    public List<Product> getProductList(){

        Collections.sort(productList);

        //Collections.sort(productList, Product.PRICE_COMPARATOR);

        //Collections.sort(productList, (p1,p2) -> Double.compare(p1.getmPrice(),p2.getmPrice()));

        return productList;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        productList = new ArrayList<Product>();

        //String mName, String mDescription, String dossage, String mBrand, double mPrice, int mStock, int mImage
        productList.add(new Product("Ibuprofeno","es ibuprofeno","1 gr","ibuprofeno",9.99,100, R.drawable.medicamento));
        productList.add(new Product("Parancetamol","es Parancetamol","0.5 gr","Parancetamol",19.99,100,R.drawable.medicamento));
        productList.add(new Product("Antiestamínico","es Antiestamínico","1 ml","Antiestamínico",29.99,100,R.drawable.medicamento));
        productList.add(new Product("Ventolin","es Ventolin","1 gr","Ventolin",39.99,80,R.drawable.medicamento));
        productList.add(new Product("Diazepan","es Diazepan","1 gr","Diazepan",5.99,100,R.drawable.medicamento));
        productList.add(new Product("Jarabe","es Jarabe","1 gr","Jarabe",2.99,100,R.drawable.medicamento));
        productList.add(new Product("Dalsy","es Dalsy","1 gr","Dalsy",0.50,100,R.drawable.medicamento));
        productList.add(new Product("Aspirina","es Aspirina","1 gr","Aspirina",6.99,100,R.drawable.medicamento));
        productList.add(new Product("Supositorio","es Supositorio","1 gr","Supositorio",0.99,120,R.drawable.medicamento));
        productList.add(new Product("Corticoide","es Corticoide","1 gr","Corticoide",1.99,75,R.drawable.medicamento));
    }


}
