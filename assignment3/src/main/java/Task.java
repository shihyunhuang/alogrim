import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task {
    // Function to sort by merge sort
    public List<List<String>> groupAnagrambyMergeSort(List<String> string){
        Map<String, List<String>> map = new HashMap<>();
        for(String s : string){
            if(s == null || s.equals("")) continue;

            String key = sortStringByMerge(s);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
    // Function to start the recursive and return sort string
    private String sortStringByMerge(String s){
        if(s.length() == 1) return s;
        char[] ch = s.toCharArray();
        char[] temp = new char[ch.length];
        mergeSort(ch, temp, 0, ch.length - 1);
        return new String(ch);
    }
    // Function to divide into tow parts and then merge
    private void mergeSort(char[] ch, char[] temp, int l, int r){
        // Divide to two parts
        if(l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(ch, temp, l, mid);
        mergeSort(ch, temp, mid + 1, r);
        // Start to merge, compare left side and right side
        int i = l, j = mid + 1, k = l;
        while (i <= mid && j <= r) {
            if (ch[i] <= ch[j]) temp[k++] = ch[i++];
            else temp[k++] = ch[j++];
        }
        while (i <= mid) temp[k++] = ch[i++];
        while (j <= r) temp[k++] = ch[j++];
        for (int p = l; p <= r; p++) ch[p] = temp[p];
    }


    // Function to sort by quick sort
    public List<List<String>> groupAnagrambyQuickSort(List<String> string){
        Map<String, List<String>> map = new HashMap<>();
        for(String s : string){
            if(s == null || s.equals("")) continue;
            char[] key_char = s.toCharArray();
            quicksort(0, s.length() - 1, key_char);
            String key = new String(key_char);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
    // Funvtion to recursive
    private void quicksort(int l, int r, char[] s){
        if(l >= r) return;
        int p = partition(l, r, s);
        // Keep sort left side and right side until the length is one
        quicksort(l, p - 1, s);
        quicksort(p + 1, r, s);
    }
    // Function to divide into two parts
    private int partition(int l, int r, char[] s){
        char pivot = s[r];
        int i = l;  // i stands for the first place bigger than pivot
        for(int j = l; j < r; j++){
            if(s[j] <= pivot){
                swap(i, j, s);
                i++;
            }
        }
        swap(i, r, s);
        return i;
    }
    // Function to sitch
    private void swap(int c1, int c2, char[] s){
        char temp = s[c1];
        s[c1] = s[c2];
        s[c2] = temp;
    }
}
