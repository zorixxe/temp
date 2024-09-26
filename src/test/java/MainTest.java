import org.example.Main;
import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


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

    @Test
    public void testFetchFriendsListPerformance() throws IOException {
        long startTime = System.nanoTime();
        List<String> friendsList = Main.fetchFriendsList("friends.txt");
        long duration = System.nanoTime() - startTime;

        System.out.println("Time taken: " + duration + " ns");

        assertTrue("Fetching took too long", duration < 1_000_000_000L);
    }
}