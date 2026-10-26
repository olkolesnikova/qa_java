import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class LionTest {

    @Mock
    Feline feline;

    @Test
    void getKittensReturnsValueFromFeline() throws Exception {

        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        int actual = lion.getKittens();
        assertEquals(1, actual);
        verify(feline).getKittens();
    }

    @Test
    void doesHaveManeReturnsTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void doesHaveManeReturnsFalseForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void getFoodReturnsListFromFeline() throws Exception {

        List<String> expected = List.of("Мясо", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expected);
        Lion lion = new Lion("Самец", feline);

        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
        verify(feline).getFood("Хищник");
    }

    @Test
    void createLionWhenSexIsInvalid() {
        Exception ex = assertThrows(Exception.class,
                () -> new Lion("Неизвестно", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                ex.getMessage());
    }
}
