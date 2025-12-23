class Solution {
    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        
        if (n == 0) return 0;
        int low = 0, high = n - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        int pivot = low;
        low = 0;
        high = n;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int real = (mid + pivot) % n;
            if (arr[real] <= x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
}
