package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline feline;

    private Lion maleLion;
    private Lion femaleLion;

    @BeforeEach
    void setUp() throws Exception {
        maleLion = new Lion("Самец", feline);
        femaleLion = new Lion("Самка", feline);
    }

    @Test
    void constructorThrowsWhenSexIsInvalid() {
        Exception ex = assertThrows(Exception.class, () -> new Lion("Неизвестно", feline));
        assertTrue(ex.getMessage().contains("Допустимые значения пола"));
    }

    @Test
    void getKittensReturnsOne() throws Exception {
        when(feline.getKittens()).thenReturn(1);

        assertEquals(1, maleLion.getKittens());
    }

    @Test
    void getKittensCallsFeline() throws Exception {
        maleLion.getKittens();

        verify(feline).getKittens();
    }

    @Test
    void getFoodReturnsCorrectFood() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(food);

        assertEquals(food, femaleLion.getFood());
    }

    @Test
    void getFoodCallsFeline() throws Exception {
        femaleLion.getFood();

        verify(feline).getFood("Хищник");
    }
}