package edu.depaul.se433.shoppingapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class TotalCostCalculatorEquivalencePartioningTests {
    @ParameterizedTest
    @MethodSource("provideWeakRobustTestInputsAndExpectedValues")
    public void testWeakRobustTestInputsAndExpectedValues(double initialCost, String state, ShippingType shippingType, double expected){
        assertEquals(expected, TotalCostCalculator.calculate(initialCost, state, shippingType));
    }

    private static Stream<Arguments> provideWeakRobustTestInputsAndExpectedValues() {
        return Stream.of(
                //           initialCost,     state,            shippingType, expectedTotal
                Arguments.of(         25,      "IL",   ShippingType.STANDARD,         36.5),
                Arguments.of(         60,      "WI",   ShippingType.NEXT_DAY,           85),
                Arguments.of(     100000,      "IL",   ShippingType.STANDARD,           -1),
                Arguments.of(          0,      "WI",   ShippingType.NEXT_DAY,           -1),
                Arguments.of(         25,  "depaul",   ShippingType.NEXT_DAY,           -1),
                Arguments.of(         60,      "WI",                    null,           -1)
                );
    }

    @ParameterizedTest
    @MethodSource("provideStrongNormalTestInputsAndExpectedValues")
    public void testStrongNormalTestInputsAndExpectedValues(double initialCost, String state, ShippingType shippingType, double expected){
        assertEquals(expected, TotalCostCalculator.calculate(initialCost, state, shippingType));
    }

    // the
    private static Stream<Arguments> provideStrongNormalTestInputsAndExpectedValues() {
        return Stream.of(
                //           initialCost,     state,            shippingType, expectedTotal
                Arguments.of(         25,      "IL",   ShippingType.STANDARD,         36.5),
                Arguments.of(         25,      "IL",   ShippingType.NEXT_DAY,         51.5),
                Arguments.of(         25,      "WI",   ShippingType.STANDARD,           35),
                Arguments.of(         25,      "WI",   ShippingType.NEXT_DAY,           50),
                Arguments.of(         60,      "IL",   ShippingType.STANDARD,         63.6),
                Arguments.of(         60,      "IL",   ShippingType.NEXT_DAY,         88.6),
                Arguments.of(         60,      "WI",   ShippingType.STANDARD,           60),
                Arguments.of(         60,      "WI",   ShippingType.NEXT_DAY,           85)
                );
    }
}
