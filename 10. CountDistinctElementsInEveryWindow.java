class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<=n-k; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j=i;j<i+k; j++) {
                set.add(arr[j]);
            }
            int length = set.size();
            list.add(length);
        }
        
        return list;
    }
}
