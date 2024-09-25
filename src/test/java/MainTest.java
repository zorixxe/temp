import org.example.Main;
import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;



public class MainTest {

    @Test
    public void testFetchFriendsListPositive() throws IOException {
        List<String> expectedList = Arrays.asList("Robin", "Daniel", "Tildeman", "Emma", "Helene");
        List<String> actualList = Main.fetchFriendsList("friends.txt");
        assertEquals(expectedList, actualList);
    }

    @Test
    public void testFetchFriendsListNegative() {
        assertThrows(IOException.class, () -> {
            Main.fetchFriendsList("non_existent_file.txt");
        });
    }

    @Test
    public void testSortFriendsListPositive() {
        List<String> unsortedList = Arrays.asList("Robin", "Daniel", "Tildeman", "Emma", "Helene");
        List<String> expectedSortedList = Arrays.asList("Daniel", "Emma", "Helene", "Robin", "Tildeman");
        List<String> actualSortedList = Main.sortFriendsList(unsortedList);
        assertEquals(expectedSortedList, actualSortedList);
    }

    @Test
    public void testSortFriendsListNegative() {
        List<String> unsortedList = Arrays.asList("Robin", "Daniel", "Tildeman", "Emma", "Helene");
        List<String> incorrectSortedList = Arrays.asList("Robin", "Daniel", "Tildeman", "Emma", "Helene");
        List<String> actualSortedList = Main.sortFriendsList(unsortedList);
        assertNotEquals(incorrectSortedList, actualSortedList);
    }
}