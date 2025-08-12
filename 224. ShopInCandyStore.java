class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        
        Arrays.sort(prices); 
        int n = prices.length;
        int start = 0, end = n - 1;
        int minCost = 0;
       
        while (start <= end) {
            minCost += prices[start++]; 
            end -= k; 
        }

        start = 0;
        end = n - 1;
        int maxCost = 0;
        while (start <= end) {
            maxCost += prices[end--]; // Buy most expensive
            start += k; 
        }

        return new ArrayList<> (Arrays.asList(minCost,maxCost));
    }
}
