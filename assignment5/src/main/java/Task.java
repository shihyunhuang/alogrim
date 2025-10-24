import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {
    // Determine whether s1 is in s2
    public boolean contain(String s1, String s2){
        // Compare two arraya contain number of each letter
        if (s1.length() > s2.length()) return false;
        int[] count_s1 = new int[26];
        for(char c : s1.toCharArray()) count_s1[c - 'a']++;

        int[] count_s2 = new int[26];
        for(int i = 0; i < s2.length(); i++){
            count_s2[s2.charAt(i) - 'a']++;
            if(i >= s1.length()) count_s2[s2.charAt(i - s1.length()) - 'a']--;
            if(Arrays.equals(count_s1, count_s2)) return true;
        }
        return false;
    }

    // Find all possible
    private List<int[]> findSolution() {
        List<int[]> ans = new ArrayList<>();
        int[] board = new int[8];
        backtrack(0, board, ans);
        return ans;
    }
    // Add queen step by step
    private void backtrack(int col, int[] board, List<int[]> ans){
        if(col == 8){
            ans.add(board.clone());
            return;
        }
        for(int row = 1; row <= 8; row++){
            if(isSafe(col, row, board)){
                board[col] = row;
                backtrack(col + 1, board, ans);
            }
        }
    }
    // Determine it's safe or not
    private boolean isSafe(int col, int row, int[] board){
        for(int c = 0; c < col; c++){
            int r = board[c];
            if(r == row) return false;
            if(Math.abs(r - row) == Math.abs(c - col)) return false;
        }
        return true;
    }
    // Determine minimun steps
    public int countSteps(int[] input){
        if (input == null || input.length != 8) throw new IllegalArgumentException("input must be an array of length 8.");
        for (int r : input) {
            if (r < 1 || r > 8) throw new IllegalArgumentException("each row must be in [1,8].");
        }
        List<int[]> solutions = findSolution();
        int best = 8;
        for(int[] sol : solutions){
            int diff = 0;
            for(int i = 0; i < sol.length; i++){
                if(input[i] != sol[i]) diff++;
                if(diff >= best) break;
            }
            if(diff < best) best = diff;
            if(best == 0) return best;
        }
        return best;
    }
}
