package edu.depaul.se433.shoppingapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class TotalCostCalculatorBoundaryTests {
    //everything between this comment and the next line comment are for the first calculate function
    @Test
    @DisplayName("Should verify $11 for total cost with initial cart cost of $1, no tax, and $10 standard shipping")
    void MinimumPurchaseAmountWithNoTaxOrFreeStandardShippingFor1stCalculateFunctionTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 1, 1);
        shoppingCart.addItem(itemToBuy);
        Bill totalCost = TotalCostCalculator.calculate(shoppingCart, "WI", ShippingType.STANDARD);
        assertEquals(new Bill((double) 1,10.00, 0.0, 11.0), totalCost);
    }

    @Test
    @DisplayName("Should verify $11.01 for total cost with initial cart cost of $1.01, no tax, and $10 standard shipping")
    void MinimumPurchaseAmountPlusOneCentWithNoTaxOrFreeStandardShippingFor1stCalculateFunctionTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 1.01, 1);
        shoppingCart.addItem(itemToBuy);
        Bill totalCost = TotalCostCalculator.calculate(shoppingCart, "WI", ShippingType.STANDARD);
        assertEquals(new Bill((double) 1.01,10.00, 0.0, 11.01), totalCost);
    }

    @Test
    @DisplayName("Should verify $35.00 for total cost with initial cart cost of $25, no tax, and $10 standard shipping")
    void NominalPurchaseAmountWithNoTaxOrFreeStandardShippingFor1stCalculateFunctionTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 25.00, 1);
        shoppingCart.addItem(itemToBuy);
        Bill totalCost = TotalCostCalculator.calculate(shoppingCart, "WI", ShippingType.STANDARD);
        assertEquals(new Bill((double) 25.00,10.00, 0.0, 35.00), totalCost);
    }

    @Test
    @DisplayName("Should verify $59.98 for total cost with initial cart cost of $49.98, no tax, and $10 standard shipping")
    void MaximumPurchaseAmountWithNoTaxOrFreeStandardShippingMinusOneCentFor1stCalculateFunctionTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 49.98, 1);
        shoppingCart.addItem(itemToBuy);
        Bill totalCost = TotalCostCalculator.calculate(shoppingCart, "WI", ShippingType.STANDARD);
        assertEquals(new Bill((double) 49.98,10.00, 0.0, 59.98), totalCost);
    }

    @Test
    @DisplayName("Should verify $59.99 for total cost with initial cart cost of $49.98, no tax, and $10 standard shipping")
    void MaximumPurchaseAmountWithNoTaxOrFreeStandardShippingFor1stCalculateFunctionTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 49.99, 1);
        shoppingCart.addItem(itemToBuy);
        Bill totalCost = TotalCostCalculator.calculate(shoppingCart, "WI", ShippingType.STANDARD);
        assertEquals(new Bill((double) 49.99,10.00, 0.0, 59.99), totalCost);
    }

    @Test
    @DisplayName("Should verify $50.00 for total cost with initial cart cost of $50.00, no tax, and free standard shipping")
    void MinimumPurchaseAmountForFreeStandardShippingFor1stCalculateFunctionTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 50.00, 1);
        shoppingCart.addItem(itemToBuy);
        Bill totalCost = TotalCostCalculator.calculate(shoppingCart, "WI", ShippingType.STANDARD);
        assertEquals(new Bill((double) 50.00,00.00, 0.0, 50.00), totalCost);
    }

    @Test
    @DisplayName("Should verify $50.01 for total cost with initial cart cost of $50.01, no tax, and free standard shipping")
    void MinimumPurchaseAmountForFreeStandardShippingPlus1CentFor1stCalculateFunctionTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 50.01, 1);
        shoppingCart.addItem(itemToBuy);
        Bill totalCost = TotalCostCalculator.calculate(shoppingCart, "WI", ShippingType.STANDARD);
        assertEquals(new Bill((double) 50.01,0.00, 0.0, 50.01), totalCost);
    }

    @Test
    @DisplayName("Should verify $60.00 for total cost with initial cart cost of $60.00, no tax, and free standard shipping")
    void NominalPurchaseAmountForFreeStandardShippingPlus1CentFor1stCalculateFunctionTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 60.00, 1);
        shoppingCart.addItem(itemToBuy);
        Bill totalCost = TotalCostCalculator.calculate(shoppingCart, "WI", ShippingType.STANDARD);
        assertEquals(new Bill((double) 60.00,0.00, 0.0, 60.00), totalCost);
    }

    @Test
    @DisplayName("Should verify $99,999.98 for total cost with initial cart cost of $99,999.98, no tax, and free standard shipping")
    void MaximumPurchaseAmountForFreeStandardShippingMinus1CentFor1stCalculateFunctionTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 99999.98, 1);
        shoppingCart.addItem(itemToBuy);
        Bill totalCost = TotalCostCalculator.calculate(shoppingCart, "WI", ShippingType.STANDARD);
        assertEquals(new Bill((double) 99999.98,0.00, 0.0, 99999.98), totalCost);
    }

    @Test
    @DisplayName("Should verify $99,999.99 for total cost with initial cart cost of $99,999.98, no tax, and free standard shipping")
    void MaximumPurchaseAmountForFreeStandardShippingFor1stCalculateFunctionTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 99999.99, 1);
        shoppingCart.addItem(itemToBuy);
        Bill totalCost = TotalCostCalculator.calculate(shoppingCart, "WI", ShippingType.STANDARD);
        assertEquals(new Bill((double) 99999.99,0.00, 0.0, 99999.99), totalCost);
    }

    //everything below this point is for the second calculate function
    @Test
    @DisplayName("Should verify $11 for total cost with initial cost of $1, no tax, and $10 standard shipping")
    void MinimumPurchaseAmountWithNoTaxOrFreeStandardShippingFor2ndCalclulateFunctionTest(){
        double totalCost = TotalCostCalculator.calculate(1, "WI", ShippingType.STANDARD);
        assertEquals(11, totalCost);
    }

    @Test
    @DisplayName("Should verify $11.01 for total cost with initial cost of $1.01, no tax, and $10 standard shipping")
    void MinimumPurchaseAmountPlusOneCentWithNoTaxOrFreeStandardShippingFor2ndCalclulateFunctionTest(){
        double totalCost = TotalCostCalculator.calculate(1.01, "WI", ShippingType.STANDARD);
        assertEquals(11.01, totalCost);
    }

    @Test
    @DisplayName("Should verify $35 for total cost with initial cost of $25, no tax, and $10 standard shipping")
    void NominalPurchaseAmountWithNoTaxOrFreeStandardShippingFor2ndCalclulateFunctionTest(){
        double totalCost = TotalCostCalculator.calculate(25, "WI", ShippingType.STANDARD);
        assertEquals(35, totalCost);
    }

    @Test
    @DisplayName("Should verify $59.98 for total cost with initial cost of $49.98, no tax, and $10 standard shipping")
    void MaximumPurchaseAmountWithNoTaxBeforeFreeStandardShippingMinusOneCentFor2ndCalclulateFunctionTest(){
        double totalCost = TotalCostCalculator.calculate(49.98, "WI", ShippingType.STANDARD);
        assertEquals(59.98, totalCost);
    }

    @Test
    @DisplayName("Should verify $59.99 for total cost with initial cost of $49.99, no tax, and $10 standard shipping")
    void MaximumPurchaseAmountWithNoTaxBeforeFreeStandardShippingFor2ndCalclulateFunctionTest(){
        double totalCost = TotalCostCalculator.calculate(49.99, "WI", ShippingType.STANDARD);
        assertEquals(59.99, totalCost);
    }

    @Test
    @DisplayName("Should verify $50 for total cost with initial cost of $50, no tax, and free standard shipping")
    void MinimumPurchaseAmountForFreeShippingWithNoTaxFor2ndCalclulateFunctionTest(){
        double totalCost = TotalCostCalculator.calculate(50, "WI", ShippingType.STANDARD);
        assertEquals(50, totalCost);
    }

    @Test
    @DisplayName("Should verify $50.01 for total cost with initial cost of $50.01, no tax, and free standard shipping")
    void MinimumPurchaseAmountForFreeShippingPlusOneCentWithNoTaxFor2ndCalclulateFunctionTest(){
        double totalCost = TotalCostCalculator.calculate(50.01, "WI", ShippingType.STANDARD);
        assertEquals(50.01, totalCost);
    }

    @Test
    @DisplayName("Should verify $60 for total cost with initial cost of $60, no tax, and free standard shipping")
    void NominalPurchaseAmountForFreeShippingWithNoTaxFor2ndCalclulateFunctionTest(){
        double totalCost = TotalCostCalculator.calculate(60, "WI", ShippingType.STANDARD);
        assertEquals(60, totalCost);
    }

    @Test
    @DisplayName("Should verify $99999.98 for total cost with initial cost of $60, no tax, and free standard shipping")
    void MaximumPurchaseAmountForFreeShippingMinusOneCentWithNoTaxFor2ndCalclulateFunctionTest(){
        double totalCost = TotalCostCalculator.calculate(99999.98, "WI", ShippingType.STANDARD);
        assertEquals(99999.98, totalCost);
    }

    @Test
    @DisplayName("Should verify $99999.99 for total cost with initial cost of $60, no tax, and free standard shipping")
    void MaximumPurchaseAmountForFreeShippingWithNoTaxFor2ndCalclulateFunctionTest(){
        double totalCost = TotalCostCalculator.calculate(99999.99, "WI", ShippingType.STANDARD);
        assertEquals(99999.99, totalCost);
    }



}
