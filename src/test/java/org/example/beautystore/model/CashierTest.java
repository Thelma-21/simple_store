package org.example.beautystore.model;

import org.example.beautystore.enums.CashierRole;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CashierTest {
    Cashier cashier = new Cashier("Ben", "34", "ben@gmail.com", CashierRole.EMPLOYED, 55);

    @Test
    void sellProducts() {
        Product p1 = new Product("Iphone", 2, 900);
        Product p2 = new Product("Mac", 3, 1000);
        Product p3 = new Product("Flask", 4, 7000);
        List<Product> listOfPurchasedProduct = new ArrayList<>();
        listOfPurchasedProduct.addAll(List.of(p1, p2, p3));


        Cart cart = new Cart(listOfPurchasedProduct);

        cashier.getStore().setProductList(listOfPurchasedProduct);
        Customer customer = new Customer("Gift", "76", "gift@gmail.com", cart, 3600000 );
        assertThat(cashier.getStore().getProduct().size()).isGreaterThan(0);
        cashier.getStore().setProductList(listOfPurchasedProduct);
        cashier.sellProducts(customer);
        assertThat(cashier.getStore().getProduct().size()).isEqualTo(0);

    }

    @Test
    void sellProducts_whenWalletAmountIsLowStoreProductListShouldRemainTheSame() {
        Product p1 = new Product("Iphone", 2, 900);
        Product p2 = new Product("Mac", 3, 1000);
        Product p3 = new Product("Flask", 4, 7000);
        List<Product> listOfPurchasedProduct = new ArrayList<>();
        listOfPurchasedProduct.addAll(List.of(p1, p2, p3));


        Cart cart = new Cart(listOfPurchasedProduct);

        cashier.getStore().setProductList(listOfPurchasedProduct);
        Customer customer = new Customer("Gift", "76", "gift@gmail.com", cart, 3600 );
        assertThat(cashier.getStore().getProduct().size()).isGreaterThan(0);
        cashier.getStore().setProductList(listOfPurchasedProduct);
        cashier.sellProducts(customer);
        assertThat(cashier.getStore().getProduct().size()).isGreaterThan(0);

    }

    @Test
    void dispensesReceipt() {
    }
}