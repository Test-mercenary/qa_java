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

    @Test
    void constructorThrowsWhenSexIsInvalid() {
        Exception ex = assertThrows(Exception.class, () -> new Lion("Неизвестно", feline));
        assertTrue(ex.getMessage().contains("допустимые значения пола"));
    }

    @Test
    void getKittensDelegatesToFeline() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    void getFoodDelegatesToFeline() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(food);
        Lion lion = new Lion("Самка", feline);
        assertEquals(food, lion.getFood());
        verify(feline).getFood("Хищник");
    }
}
