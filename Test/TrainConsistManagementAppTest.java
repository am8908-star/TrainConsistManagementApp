import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class TrainConsistManagementAppTest {

    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Test
    void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        bubbleSort(arr);

        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] arr = {24, 56, 60, 70, 72};
        bubbleSort(arr);

        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, arr);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] arr = {72, 56, 56, 24};
        bubbleSort(arr);

        assertArrayEquals(new int[]{24, 56, 56, 72}, arr);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] arr = {50};
        bubbleSort(arr);

        assertArrayEquals(new int[]{50}, arr);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] arr = {40, 40, 40};
        bubbleSort(arr);

        assertArrayEquals(new int[]{40, 40, 40}, arr);
    }
}