package org.example.beautystore.model;

import org.example.beautystore.interfaces.BuyProducts;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person implements BuyProducts {
    private Cart cart;
    private float walletAmount;

    public Customer(String name, String number, String email, Cart cart, float walletAmount) {
        super(name, number, email);
        this.cart = cart;
        this.walletAmount = walletAmount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public float getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(float walletAmount) {
        this.walletAmount = walletAmount;
    }


    @Override
    public boolean canBuyProduct() {
        List<Product> newProductList = new ArrayList<>();
        if (cart.getPurchasedProduct().size() > 0) {
            if(this.getWalletAmount() >= cart.getTotalPriceOfCart() && cart.getTotalPriceOfCart() > 0){
                float bal = this.getWalletAmount() - cart.getTotalPriceOfCart();
                this.setWalletAmount(bal);
                System.out.println("transaction complete");
                return true;
            }
            else {
                System.out.println("Insufficient fund");
                return false;
            }
        }else {
            System.out.println("you have not selected any product yet");
            return false;
        }
    }
}