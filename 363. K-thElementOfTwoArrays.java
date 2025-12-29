class Solution {
    int count(int[] arr, int x) {
        int s = 0;
        int e = arr.length - 1;
        int ans = arr.length;
        
        while(s <= e) {
            int mid = s + (e - s) / 2;
            
            if(arr[mid] > x) {
                ans = mid;
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return ans;
    }
    boolean check(int[] a, int[] b, int mid, int k) {
        int countA = count(a, mid);
        int countB = count(b, mid);
        return countA + countB >= k;
    } 
    public int kthElement(int a[], int b[], int k) {
        // code here
        int s = Math.min(a[0], b[0]);
        int e = Math.max(a[a.length - 1], b[b.length - 1]);
        
        int ans = -1;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            if(check(a, b, mid, k)) {
                ans = mid;
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        return ans;
    }
}
