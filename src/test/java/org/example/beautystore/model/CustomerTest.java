package org.example.beautystore.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.MethodOrderer.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class CustomerTest {

    private Product p1;
    private Product p2;
    private Product p3;
    private List<Product> listOfPurchasedProduct;
    private Cart cart;

    private Customer customer;
    private Customer customer2;

    @BeforeEach
    void setUp() {
        p1 = new Product("Iphone", 2, 900);
        p2 = new Product("Mac", 3, 1000);
        p3 = new Product("Flask", 4, 7000);
        listOfPurchasedProduct = new ArrayList<>();
        listOfPurchasedProduct.addAll(List.of(p1, p2, p3));
        cart = new Cart(listOfPurchasedProduct);
        customer = new Customer("Gift", "76", "gift@gmail.com", cart, 3600000 );
        customer2 = new Customer("Gift", "76", "gift@gmail.com", cart, 360);
    }

    @Test
    @Order(1)
    void canBuyProduct() {
        assertTrue(customer.canBuyProduct());
    }

    @Test
    @Order(2)
    void canBuyProduct_ShouldReturnFalse() {
        assertFalse(customer2.canBuyProduct());
    }

    @Test
    @Order(3)
    void canBuyProduct_ShouldReturnFalse2() {
        cart.setPurchasedProduct(Collections.emptyList());
        assertFalse(customer.canBuyProduct());
    }
}