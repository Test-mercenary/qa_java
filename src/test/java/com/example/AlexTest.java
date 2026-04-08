package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlexTest {

    @Mock
    private Feline feline;
    private Alex alex;

    @BeforeEach
    void setUp() {
        alex = new Alex(feline);
    }

    @Test
    void alexIsMaleLion() throws Exception {
        assertTrue(alex.doesHaveMane());
    }

    @Test
    void getKittensAlwaysZero() throws Exception {
        assertEquals(0, alex.getKittens());
        verify(feline, never()).getKittens();
    }

    @Test
    void getFriendsReturnsMadagascarCharacters() throws Exception {
        assertEquals(
                List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман"),
                alex.getFriends());
    }

    @Test
    void getPlaceOfLivingReturnsNewYorkZoo() throws Exception {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void getFoodStillUsesFeline() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(food);
        assertEquals(food, alex.getFood());
        verify(feline).getFood("Хищник");
    }
}
