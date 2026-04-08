import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private boolean safeSearch(String[] arr, String key) {
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};

        Exception ex = assertThrows(IllegalStateException.class, () -> {
            safeSearch(arr, "BG101");
        });

        assertEquals("No bogies available for search", ex.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101","BG205"};

        assertDoesNotThrow(() -> safeSearch(arr, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        assertTrue(safeSearch(arr, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        assertFalse(safeSearch(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};

        assertTrue(safeSearch(arr, "BG101"));
    }
}