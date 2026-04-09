package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineParameterizedTest {

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "5, 5"})
    void getKittensWithCountReturnsSameCount(int count, int expected) {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(count));
    }
}
