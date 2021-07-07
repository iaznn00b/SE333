package edu.depaul.se433.shoppingapp;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class averagePurchaseMocksTest {
    @Test
    @DisplayName("Verifies the correct average purchase with an empty (fake) database")
    void averagePurchaseWithEmptyDatabaseTest() {
        PurchaseDBO purchaseDBO = mock(PurchaseDBO.class);
        PurchaseAgent purchaseAgent = new PurchaseAgent(purchaseDBO);

        assertEquals(0, purchaseAgent.averagePurchase("John"));
    }

    @Test
    @DisplayName("Verifies the correct average purchase with a non-empty (fake) database")
    void averagePurchaseWithNonEmptyDatabaseTest() {
        PurchaseDBO purchaseDBO = mock(PurchaseDBO.class);
        PurchaseAgent purchaseAgent = new PurchaseAgent(purchaseDBO);

        purchaseDBO.savePurchase(Purchase.make("John", LocalDate.now(), 1.00, "IL", "STANDARD"));
        System.out.println(purchaseDBO.getPurchases("John").toString());
        assertEquals(1, purchaseAgent.averagePurchase("John"));
    }

    @Test
    @DisplayName("Verifies the correct call to the mock database is made in the save function")
    void CallSavePurchaseFunctionTest() {
        PurchaseDBO purchaseDBO = mock(PurchaseDBO.class);
        PurchaseAgent purchaseAgent = new PurchaseAgent(purchaseDBO);
        Purchase myPurchase = new Purchase();

        purchaseAgent.save(myPurchase); //"saves" purchase to mock database
        verify(purchaseDBO, times(1)).savePurchase(myPurchase);
    }

    @Test
    @DisplayName("Verifies the correct call to the mock database is made in the save function")
    void CallSavePurchaseFunctionTest2() {
        PurchaseDBO purchaseDBO = mock(PurchaseDBO.class);
        PurchaseAgent purchaseAgent = new PurchaseAgent(purchaseDBO);

        purchaseAgent.save(null); //"saves" purchase to mock database
        verify(purchaseDBO, times(1)).savePurchase(null);
    }
}
