import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TaskTest {
    Task t = new Task();
    @Test
    void testTask1(){
        // Case 1 = Normal test
        int[] nums1 = {4, 9, 10, 13, 17, 17, 19, 21};
        int[] expect1 = {4, 5};
        assertArrayEquals(expect1, t.Task1(nums1, 17));

        // Case 2: Every value is smaller than target
        int[] nums2 = {2, 4, 6, 8, 10, 14, 16};
        int[] expect2 = {-1, -1};
        assertArrayEquals(expect2, t.Task1(nums2, 12));

        // Case 3: Array is empty
        int[] nums3 = {};
        int[] expect3 = {-1, -1};
        assertArrayEquals(expect3, t.Task1(nums3, 0));

        // Case 4: Target is the first index
        int[] nums4 = {3, 3, 5, 7, 9};
        int[] expect4 = {0, 1};
        assertArrayEquals(expect4, t.Task1(nums4, 3));

        // Case 5: Target is the last index
        int[] nums5 = {1, 2, 3, 4, 4};
        int[] expect5 = {3, 4};
        assertArrayEquals(expect5, t.Task1(nums5, 4));

        // Case 6: Array only have one index
        int[] nums6 = {5};
        int[] expect6 = {0, 0};
        assertArrayEquals(expect6, t.Task1(nums6, 5));

        // Case 7: Every value is bigger than target
        int[] nums7 = {5, 7, 9, 11, 13, 15, 18, 21, 25, 30, 35, 40, 45};
        int[] expect7 = {-1, -1};
        assertArrayEquals(expect7, t.Task1(nums7, 4));
    }

    @Test
    void testTask2(){
        // Case 1: Normal case
        int[][] matrix1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(t.Task2(matrix1, 3));
        assertFalse(t.Task2(matrix1, 13));

        // Case 2: Target is in different place
        int[][] matrix2 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(t.Task2(matrix2, 1)); // First
        assertTrue(t.Task2(matrix2, 60)); // Last

        // Case 3: One row
        int[][] matrix3 = {{2, 4, 6, 8, 10, 12}};
        assertTrue(t.Task2(matrix3, 8));
        assertFalse(t.Task2(matrix3, 5));

        // Case 4: One column
        int[][] matrix4 = {{1}, {3}, {5}, {7}, {9}};
        assertTrue(t.Task2(matrix4, 7));
        assertFalse(t.Task2(matrix4, 6));

        // Case 5: One element
        int[][] matrix5 = {{42}};
        assertTrue(t.Task2(matrix5, 42));
        assertFalse(t.Task2(matrix5, 41));

        // Case 6: Empty
        int[][] matrix6 = {};
        assertFalse(t.Task2(matrix6, 10));

        // Case 7: Empty
        int[][] matrix7 = {{}};
        assertFalse(t.Task2(matrix7, 10));
    }
}
