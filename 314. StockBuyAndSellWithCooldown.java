class Solution {
    public int maxProfit(int arr[]) {
        
        if (arr == null || arr.length == 0) return 0;
        int hold = -arr[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < arr.length; ++i) {
            int p = arr[i];
            int newHold = Math.max(hold, rest - p);
            int newSold = hold + p;
            int newRest = Math.max(rest, sold);

            hold = newHold;
            sold = newSold;
            rest = newRest;
        }
        return Math.max(sold, rest);
    }
}
