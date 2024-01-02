public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution stockProfit = new Solution();
        
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit for prices1: " + stockProfit.maxProfit(prices1)); // Output: 5
        
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max profit for prices2: " + stockProfit.maxProfit(prices2)); // Output: 0
    }
}
