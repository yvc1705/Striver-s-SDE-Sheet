import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        // Sort the intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                merged.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        
        merged.add(currentInterval);
        
        return merged.toArray(new int[merged.size()][]);
    }
}
