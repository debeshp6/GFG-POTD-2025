class Solution {
    public int maxPartitions(String s) {
        // code here
        int cnt = 0;
        int[] arr = new int[26];
        for(int i=0; i<s.length(); ++i) {
            int id = s.charAt(i) - 'a';
            arr[id] = i;
        }
        
        int r = -1;
        for(int i=0; i<s.length(); ++i) {
            r = Math.max(r,arr[s.charAt(i) - 'a']);
            if(r == i) cnt++;
        }
        return cnt;
    }
}
