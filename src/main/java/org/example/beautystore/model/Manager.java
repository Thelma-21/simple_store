package org.example.beautystore.model;

import org.example.beautystore.enums.CashierRole;
import org.example.beautystore.interfaces.HireACashier;

public class Manager extends Person implements HireACashier{

    public Manager(String name, String number, String email) {
        super(name, number, email);
    }

    private static Manager manager = new Manager();

    private Manager(){
        super();

    }
    public static Manager getInstance(){
        if(manager == null){
            manager = new Manager();
        }
        return manager;
    }


    @Override
    public void canHireACashier(Cashier cashier) {
        //Checks if the Cashier scores up to 50 and above and hire him/her
        if(cashier.getRole() == CashierRole.APPLICANT){
            if(cashier.getAssessmentScore() > 50){
                cashier.setRole(CashierRole.EMPLOYED);
                System.out.println("congratulations");
            }else{
                System.out.println("We would have been happy to work with you," +
                        "however your score does not meet the passmark for a cashier role. Thanks");
            }
        }
    }
}
