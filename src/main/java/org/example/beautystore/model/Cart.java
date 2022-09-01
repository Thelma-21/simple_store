package org.example.beautystore.model;

import java.util.List;

public class Cart {
    List<Product> purchasedProduct;

    public Cart(List<Product> purchasedProduct) {
        this.purchasedProduct = purchasedProduct;
    }

    public List<Product> getPurchasedProduct() {
        return purchasedProduct;
    }

    public void setPurchasedProduct(List<Product> purchasedProduct) {
        this.purchasedProduct = purchasedProduct;
    }
    public float getTotalPriceOfCart(){
        float sum = 0;
        for (Product product : purchasedProduct) {
            sum += product.getPrice() * product.getQuantity() ;
        }
        return sum;
    }
}
