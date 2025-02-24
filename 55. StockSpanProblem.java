


class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);

        // ***** using j to traverse backwards & count for previous required small values *****

        int count = 1, j = 0;
        for(int i=1; i<arr.length; i++) {
            j = i-1;
            while(j>=0 && arr[i] >= arr[j]) {
                count++;
                j--;
            }
            res.add(count);
            count = 1;
        }
        
        return res;
    }
}
