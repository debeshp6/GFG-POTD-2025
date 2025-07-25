class Solution {
    public int maxCircularSum(int arr[]) {
        
        int n = arr.length;
        int maxKadane = kadaneMax(arr);
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
      
        int minKadane = kadaneMin(arr);
        int maxCircular = totalSum - minKadane;
        if (maxCircular == 0) {
            return maxKadane;
        }
 
        return Math.max(maxKadane, maxCircular);
    }
 
    private int kadaneMax(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
 
    private int kadaneMin(int[] arr) {
        int minSoFar = arr[0];
        int minEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minEndingHere = Math.min(arr[i], minEndingHere + arr[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        return minSoFar;
    }
}
