class Solution {
    public void sortIt(int[] arr) {
        
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> even = new PriorityQueue<>();

        for (int i : arr) {
            if (i % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        int[] result = new int[arr.length];

        int oddCount = odd.size(); //** The problem: odd.size() keeps shrinking as you poll()
        for (int i = 0; i < arr.length; i++) {
            if (i < oddCount) { //Don't use it here directly 
                arr[i] = odd.poll();
            } else {
                arr[i] = even.poll();
            }
        }
    }
}

