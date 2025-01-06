

class Solution {
    public long subarrayXor(int arr[], int k) {
        
        int n = arr.length;
        int xor = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(xor,1);
        int cnt = 0;
        
        for(int i=0; i<n; i++) {
            xor = xor ^ arr[i];
            int p = xor ^ k;
            if(map.containsKey(p)) {
                cnt += map.get(p);
            }
            if(map.containsKey(xor)) {
                map.put(xor,map.get(xor) + 1);
            }
            else {
                map.put(xor,1);
            }
        }
        
        return cnt;
    }
}
