class Solution {
    public int maxXor(int[] arr) {
        
        int n =arr.length;
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                count = Math.max(count, arr[i] ^ arr[j]);
            }
        }
        return count;
    }
}
