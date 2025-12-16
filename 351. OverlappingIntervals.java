class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> list = new ArrayList<>();
        int[] cur = Arrays.copyOf(arr[0],2);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i][0] <= cur[1]){
                cur[1] = Math.max(cur[1], arr[i][1]);
            }
            else{
                list.add(cur);
                cur = Arrays.copyOf(arr[i], 2);
            }
        }
        list.add(cur);
        return list;
    }
}
