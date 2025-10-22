import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TaskTest {
    Task task = new Task();
    // Case 1: Normal list
    List<String> list_1 = Arrays.asList("mango", "ogman", "banana", "aaabnn", "abc", "cab", "bca");
    // Case 2: List contain null
    List<String> list_2 = Arrays.asList("", null, "a", "A", "aa", "bb", "ab", "ba");
    // Case 3: Long list
    List<String> list_3 = Arrays.asList(
        "listen", "silent", "enlist", "tinsel", "inlets",
        "stone", "tones", "notes",
        "apple", "papel", "pplea",
        "loop", "pool", "polo"
    );

    @Test
    void testMergeSort(){
        List<List<String>> case1= task.groupAnagrambyMergeSort(list_1);
        List<List<String>> case2= task.groupAnagrambyMergeSort(list_2);
        List<List<String>> case3= task.groupAnagrambyMergeSort(list_3);
        System.out.println("===== MergeSort =====");
        System.out.println("===== Case 1 =====");
        System.out.println(case1);

        System.out.println("===== Case 2 =====");
        System.out.println(case2);

        System.out.println("===== Case 3 =====");
        System.out.println(case3);
        System.out.println("");
    }

    @Test
    void testQuickSort(){
        List<List<String>> case1= task.groupAnagrambyQuickSort(list_1);
        List<List<String>> case2= task.groupAnagrambyQuickSort(list_2);       
        List<List<String>> case3= task.groupAnagrambyQuickSort(list_3);
        System.out.println("===== QuickSort =====");
        System.out.println("===== Case 1 =====");
        System.out.println(case1);

        System.out.println("===== Case 2 =====");
        System.out.println(case2);

        System.out.println("===== Case 3 =====");
        System.out.println(case3);
        System.out.println("");
    }
}