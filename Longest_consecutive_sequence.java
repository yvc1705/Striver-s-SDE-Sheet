import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLen = 0;
        
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }
                
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        
        return maxLen;
    }
}
