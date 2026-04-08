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
    void getKittensReturnsZero() throws Exception {
        assertEquals(0, alex.getKittens());
    }

    @Test
    void getKittensDoesNotCallFeline() throws Exception {
        alex.getKittens();
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
    void getFoodReturnsCorrectFood() throws Exception {
        assertEquals(food, alex.getFood());
    }

    @Test
    void getFoodCallsFeline() throws Exception {
        alex.getFood();
        verify(feline).getFood("Хищник");
    }
}
