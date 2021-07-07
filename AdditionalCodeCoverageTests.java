package edu.depaul.se433.shoppingapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class AdditionalCodeCoverageTests {
    @ParameterizedTest
    @MethodSource("provideAdditionalTestInputsAndExpectedValues")
    public void testAdditionalTestInputsAndExpectedValues(double initialCost, String state, ShippingType shippingType, double expected){
        assertEquals(expected, TotalCostCalculator.calculate(initialCost, state, shippingType));
    }

    //test the totals for shipping to NY and CA
    private static Stream<Arguments> provideAdditionalTestInputsAndExpectedValues() {
        return Stream.of(
                //           initialCost,     state,            shippingType, expectedTotal
                Arguments.of(         25,      "NY",   ShippingType.STANDARD,         36.5),
                Arguments.of(         25,      "CA",   ShippingType.STANDARD,         36.5)
        );
    }


    @Test
    @DisplayName("Should verify a shopping cart size of 1")
    void shoppingCartSizeTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 1, 1);
        shoppingCart.addItem(itemToBuy);
        assertEquals(1, shoppingCart.itemCount());
    }

    @Test
    @DisplayName("Should verify a shopping cart that has been cleared has a size of 0")
    void shoppingCartClearTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 1, 1);
        shoppingCart.addItem(itemToBuy);
        shoppingCart.clear();
        assertEquals(0, shoppingCart.itemCount());
    }

    @Test
    @DisplayName("Should return the correct items in a shopping cart")
    void shoppingCartGetCorrectItemsTest(){
        ShoppingCart shoppingCart = new ShoppingCart();
        PurchaseItem itemToBuy = new PurchaseItem("socks", 1, 1);
        shoppingCart.addItem(itemToBuy);

        HashMap<Long, PurchaseItem> myHashMap = new HashMap<>();
        Long myLong = new Long(1);
        myHashMap.put(myLong, itemToBuy);
        assertEquals(myHashMap, shoppingCart.getItems());
    }
}
