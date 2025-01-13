class Solution {

    public int maxWater(int arr[]) {
        
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int ans = 0;
        
        while(left < right) {
            int temp = Math.min(arr[left],arr[right]) * (right-left);
            ans = Math.max(ans,temp);
            if(arr[left] < arr[right])
                left++;
            else right--;
        }
        
        return ans;
    }
}
