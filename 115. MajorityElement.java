// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        
        int n = arr.length;
        int el = 0, cnt = 0;
        
        for(int nums : arr) {
            
            if(cnt == 0) {
                el = nums;
                cnt = 1;
            }
            else if(el == nums)
                cnt++;
            else 
                cnt--;
        }
        
        int count = 0;
        for(int nums : arr) {
            if(el == nums) count++;
            if(count > n/2) return el;
        }
        
        return -1;
        
    }
}
