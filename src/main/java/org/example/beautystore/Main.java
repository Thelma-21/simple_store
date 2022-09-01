package org.example.beautystore;

import org.example.beautystore.enums.CashierRole;
import org.example.beautystore.model.*;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
    Manager manager = Manager.getInstance();
    Cashier cashier1 = new Cashier("Bill", "08230654786", "billy@gmail.com", CashierRole.EMPLOYED, 60);
    Cashier cashier2 = new Cashier("Bill", "08230654786", "billy@gmail.com", CashierRole.APPLICANT, 40);
    manager.canHireACashier(cashier1);
    manager.canHireACashier(cashier2);

    List<Product> listOfPurchasedProduct = new ArrayList<>();
    Cart cart = new Cart(listOfPurchasedProduct);
    Customer customer1 = new Customer("Ada", "678-865-345", "ada@gmail.com", cart, 109500);
//    Customer customer2 = new Customer("Frank", "678-865-345", "frank@gmail.com", cart, 7500);

    Product product1 = new Product("concealer", 3, 2500);
    Product product2 = new Product("powder", 2, 4500);
    listOfPurchasedProduct.add(product1);
    listOfPurchasedProduct.add(product2);
    cashier1.getStore().setProductList(listOfPurchasedProduct);

    System.out.println(cashier1.getStore().getProduct().size() + " products was added");

    System.out.println();

    customer1.getCart().setPurchasedProduct(listOfPurchasedProduct);
    System.out.println(cart.getTotalPriceOfCart());
    System.out.println(customer1.getWalletAmount());
    customer1.canBuyProduct();
    cashier1.sellProducts(customer1);
//    cashier1.dispensesReceipt(customer1);
    System.out.println(cashier1.getStore().getProduct().size());

    }

}