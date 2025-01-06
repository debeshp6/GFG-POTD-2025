// User function Template for Java
class Solution {
    public int countSubarrays(int arr[], int k) {
        
        int n = arr.length;
        int preSum = 0;
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<n; i++) {
            preSum += arr[i];
            int remove = preSum - k;
            cnt += map.getOrDefault(remove,0);
            map.put(preSum, map.getOrDefault(preSum,0) + 1);
        }
        
        return cnt;
    }
}
