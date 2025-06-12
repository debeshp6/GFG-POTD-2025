

class Solution {
    static boolean is_possible(int[] arr, int mid, int k) {
        
        int hours = 0;
        for (int i = 0; i < arr.length; i++) {
            hours += (int) Math.ceil((double)arr[i]/mid);
        }
        
        return hours <= k;
    }
    public static int kokoEat(int[] arr, int k) {
        // code here
        int max = Arrays.stream(arr).max().getAsInt();
        if (arr.length == k) {
            return max;
        }
        
        int s = 1;
        int e = max;
        
        while(s < e) {
            int mid = s + (e - s) / 2;
            if(is_possible(arr, mid, k)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        
        return s;
    }
}

