import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CatTest {

    @Mock
    Feline feline;

    @Test
    void getSoundReturnMeow() {

        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodReturnListPositive() throws Exception {

        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);
        Cat cat = new Cat(feline);

        assertEquals(expected, cat.getFood());
        verify(feline).eatMeat();
    }

    @Test
    void getFoodReturnException() throws Exception {

        when(feline.eatMeat()).thenThrow(new Exception("Нет еды"));
        Cat cat = new Cat(feline);
        assertThrows(Exception.class, cat::getFood);
    }
}
