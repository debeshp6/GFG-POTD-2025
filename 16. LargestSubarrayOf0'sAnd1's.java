class Solution {
    public int maxLen(int[] arr) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int sum = 0;
        int ans = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i] == 1 ? 1:-1;
            if(sum == 0) ans = i+1;
            if(map.get(sum) != null)
                ans = Math.max(ans, i-map.get(sum));
            else map.put(sum,i);
        }
        
        return ans;
    }
}
