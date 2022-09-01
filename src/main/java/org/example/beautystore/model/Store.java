package org.example.beautystore.model;

import java.util.List;

public class Store {
    private List<Product> product;

    public Store(List<Product> product) {

        this.product = product;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProductList(List<Product> productList) {
        this.product = productList;
    }
}
