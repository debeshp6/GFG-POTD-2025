


class Solution {
    public static int minCost(int[] arr) {
        if (arr.length == 1) return 0; 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : arr) {
            minHeap.add(rope);
        }
        
        int totalCost = 0;
        
        while (minHeap.size() > 1) {
            int first = minHeap.poll(); 
            int second = minHeap.poll(); 
            int cost = first + second;
            totalCost += cost;
            minHeap.add(cost); 
        }
        
        return totalCost;
    }
}
