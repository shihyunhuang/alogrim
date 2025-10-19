public class Task {

    public int[] Task1(int[] array, int target){
        if(array.length == 0) return new int[]{-1, -1};
        int first = lowerbound(array, target);
        /* 
        If target cannot find in the array:
        1. Target id larger than all value in array
        2. first is the first index larger than target
        */
        if(first == array.length || array[first] != target) return new int[]{-1, -1};

        int last = upperbound(array, target) - 1;
        return new int[]{first, last};
    }
    // Find the first target
    private int lowerbound(int[] array, int target){
        int l = 0;
        int r = array.length;
        while(l < r){
            int m = l + (r - l) / 2;
            if(array[m] >= target) r = m;   // Find the first index >= target
            else l = m + 1;
        }
        return l;
    }
    // Find the last target
    private int upperbound(int[] array, int target){
        int l = 0;
        int r = array.length;
        while(l < r){
            int m = l + (r - l) / 2;
            if(array[m] > target) r = m;    // Find the first index > target
            else l = m + 1;
        }
        return l;
    }

    public boolean Task2(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int len = row * col;
        
        int l = 0;
        int r = len - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int midrow = mid / col;
            int midcol = mid % col;
            int value = matrix[midrow][midcol];
            if(value == target) return true;
            else if(value < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}
