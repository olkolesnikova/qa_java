import com.example.Feline;
import com.example.LionAlex;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

public class LionAlexTest {

    @Mock
    Feline feline;

    @Test
    void getFriendsReturnsListOfFriends() throws Exception {

        LionAlex alex = new LionAlex(feline);
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        List<String> actual = alex.getFriends();
        assertEquals(expected, actual);

    }

    @Test
    void getPlaceOfLivingReturnsNewYorkZoo() throws Exception {
        LionAlex alex = new LionAlex(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void getKittensReturnsZero() throws Exception {
        LionAlex alex = new LionAlex(feline);
        assertEquals(0, alex.getKittens());
    }

}
