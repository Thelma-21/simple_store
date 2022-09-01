package org.example.beautystore.model;

import org.example.beautystore.enums.CashierRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager manager = new Manager("Kay", "090436678", "kay@gmail.com");



    @Test
    void canHireACashier_shouldSetRoleToEmployed() {
        Cashier cashier = new Cashier("Cashier", "4", "cashier@gmail.com", CashierRole.APPLICANT, 51);
        manager.canHireACashier(cashier);
        assertEquals(CashierRole.EMPLOYED, cashier.getRole());
    }

    @Test
    void canHireACashier() {
        Cashier cashier = new Cashier("Cashier", "4", "cashier@gmail.com", CashierRole.APPLICANT, 50);
        manager.canHireACashier(cashier);
        assertNotEquals(CashierRole.EMPLOYED, cashier.getRole());
    }



}