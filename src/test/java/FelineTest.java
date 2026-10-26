import com.example.Feline;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class FelineTest {

    @Test
    void eatMeatReturnsPredatorFood() throws Exception {

        Feline feline = spy(new Feline());
        doReturn(List.of("Животные", "Птицы", "Рыба"))
                .when(feline).getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    void eatMeatCallsGetFoodPredator() throws Exception {

        Feline feline = spy(new Feline());
        doReturn(List.of("Животные", "Птицы", "Рыба"))
                .when(feline).getFood("Хищник");
        feline.eatMeat();
        verify(feline).getFood("Хищник");

    }

    @Test
    void eatMeatWithException() throws Exception {
        Feline feline = spy(new Feline());
        doThrow(new Exception("unexpected")).when(feline).getFood("Хищник");
        assertThrows(Exception.class, feline::eatMeat);
    }

    @Test
    void getFamilyReturnsFelineFamily() {

        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getFoodEmptyList() {
        Feline feline = new Feline();
        assertEquals(List.of(), feline.getFood());
    }

    @Test
    void getKittensWithoutParamReturnsExpected() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

}
