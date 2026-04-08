import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    private List<Bogie> getSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 24));
        return bogies;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int total = getSampleBogies()
                .stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(150, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = getSampleBogies()
                .stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(150, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Integer> capacities = getSampleBogies()
                .stream()
                .map(b -> b.capacity)
                .toList();

        assertEquals(Arrays.asList(72, 54, 24), capacities);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        int total = getSampleBogies()
                .stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(150, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();

        int total = original.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(3, original.size());
        assertEquals(150, total);
    }
}