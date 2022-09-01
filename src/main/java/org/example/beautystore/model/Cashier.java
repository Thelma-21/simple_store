package org.example.beautystore.model;

import org.example.beautystore.enums.CashierRole;
import org.example.beautystore.interfaces.CashierDuty;

import java.util.Collections;
import java.util.List;

public class Cashier extends Person implements CashierDuty {
    private CashierRole role;
    private Store store = new Store(Collections.emptyList());
    private int assessmentScore;


    public Cashier(String name, String number, String email, CashierRole role, int assessmentScore) {
        super(name, number, email);
        this.role = role;
        this.assessmentScore = assessmentScore;
    }

    public CashierRole getRole() {
        return role;
    }

    public void setRole(CashierRole role) {
        this.role = role;
    }

    public int getAssessmentScore() {
        return assessmentScore;
    }

    public void setAssessmentScore(int assessmentScore) {
        this.assessmentScore = assessmentScore;
    }


    @Override
    public void sellProducts(Customer customer) {
        if (role != CashierRole.EMPLOYED) {
            System.out.println("Cashier not authorized to sell");
        }
        if (store.getProduct().isEmpty()) {
            System.out.println("There is no market");
            return;
        }
        List<Product> bought = compareItemsInCartWithStore(customer.getCart());
        if(customer.getWalletAmount()>= customer.getCart().getTotalPriceOfCart()){
            dispensesReceipt(customer);
            store.getProduct().removeAll(bought);
        }
        else
            System.out.println("Wallet amount is too low for the transaction");

    }

    private List<Product> compareItemsInCartWithStore(Cart cart) {
        return cart.getPurchasedProduct();
    }

    private void dispensesReceipt(Customer customer) {
        for(Product product : customer.getCart().purchasedProduct){
            System.out.println(product.getName() + ": " + product.getQuantity() + ": " + product.getPrice() );
        }
        System.out.println(" Total Amount " + customer.getCart().getTotalPriceOfCart());
        System.out.println("Thanks for your patronage");
    }

    public Store getStore() {
        if (role.equals(CashierRole.APPLICANT)) {
            return null;
        }
        return store;
    }
}
