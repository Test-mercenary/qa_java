package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline feline;
    private Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat(feline);
    }// test updated

    @Test
    void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodReturnsCorrectFood() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

    @Test
    void getFoodReturnsCorrectFood() throws Exception {
        cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}
