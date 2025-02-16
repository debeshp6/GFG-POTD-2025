

class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i =1 ; i<= k ; i++){
            int curr = arr[arr.length -i];
            ans.add(curr);
        }
        return ans ;
    }
}
