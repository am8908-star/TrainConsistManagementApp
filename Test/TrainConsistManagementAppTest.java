import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
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
        bogies.add(new Bogie("Luxury", 80));
        return bogies;
    }

    private List<Bogie> getLargeDataset() {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Bogie" + i, i % 100));
        }
        return bogies;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = new ArrayList<>();

        for (Bogie b : getSampleBogies()) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }

        assertEquals(2, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = getSampleBogies()
                .stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = new ArrayList<>();

        for (Bogie b : getSampleBogies()) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = getSampleBogies()
                .stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = getLargeDataset();

        long start = System.nanoTime();

        bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = getLargeDataset();

        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}