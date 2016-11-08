package com.example.espino.manageproductrecycler.Modelo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Locale;

/**
 * Class product
 * */

public class Product implements Comparable<Product>, Serializable{

    private int mId;
    private String mName;
    private String mDescription;
    private String dossage;
    private String mBrand;
    private double mPrice;
    private int mStock;
    private int mImage;  //(o1, o2) -> o1.getmPrice() - o2.getmPrice();

    public static final Comparator<Product> PRICE_COMPARATOR = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
           return Double.compare(o1.getmPrice(), o2.getmPrice());
        }
    };
    public static final Comparator<Product> STOCK_COMPARATOR = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getmStock() - o2.getmStock();
        }
    };


    public Product(String mName, String mDescription, String dossage, String mBrand, double mPrice, int mStock, int mImage) {
       // mId = UUID.randomUUID().toString(); mirarlo
        this.mName = mName;
        this.mDescription = mDescription;
        this.dossage = dossage;
        this.mBrand = mBrand;
        this.mPrice = mPrice;
        this.mStock = mStock;
        this.mImage = mImage;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public String getDossage() {
        return dossage;
    }

    public void setDossage(String dossage) {
        this.dossage = dossage;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmBrand() {
        return mBrand;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public int getmStock() {
        return mStock;
    }

    public void setmStock(int mStock) {
        this.mStock = mStock;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getFormattedPrice(){
        return String.format("€%s", mPrice);
    }

    public String getFormattedUnitsinStocks(){
        return String.format(Locale.getDefault(), "%d u.",mStock);
    }

    /*2 productos son iguales cuando tienen el mismo nombre la misma marca y la misma dosificacion*/

    public String toString(){
        return "Nombre: " + mName + "\nMarca: " + mBrand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (mName != null ? !mName.equals(product.mName) : product.mName != null) return false;
        if (dossage != null ? !dossage.equals(product.dossage) : product.dossage != null)
            return false;
        return mBrand != null ? mBrand.equals(product.mBrand) : product.mBrand == null;

    }

    public int compareTo(Product p){
        if(this.getmName().compareTo(p.getmName()) == 0)
            return this.getmBrand().compareTo(p.getmBrand());
        else
            return this.getmName().compareTo(p.getmName());

    }
}
