class Solution {
    public void rearrange(int[] arr, int x) {
        Integer[] temp = Arrays.stream(arr).boxed().
        toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int diff1 = Math.abs(a - x);
            int diff2 = Math.abs(b - x);
            return Integer.compare(diff1,diff2);
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
