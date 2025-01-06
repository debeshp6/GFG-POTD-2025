
// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0, j = n-1;
        List<Integer> list = new ArrayList<>();
        int closestSum = Integer.MAX_VALUE;
        
        while(i < j) {
            int sum = arr[i] + arr[j];
            if (Math.abs(target - sum) < Math.abs(target - closestSum) ||
                (Math.abs(target - sum) == Math.abs(target - closestSum) && (arr[j] - arr[i]) > (list.size() > 1 ? list.get(1) - list.get(0) : -1))) {
                closestSum = sum;
                list = Arrays.asList(arr[i], arr[j]);
            }
            
            if(sum < target) i++;
            else j--;
        }
        
        return list;
    }
}
