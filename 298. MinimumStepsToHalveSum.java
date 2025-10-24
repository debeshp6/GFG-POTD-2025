class Solution {
    public int minOperations(int[] arr) {
        
        double sum = 0;
        int n = arr.length;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int val : arr){
            pq.add((double)val);
            sum += val;
        }
        
        double half = sum / 2.0;
        int count = 0;
        
        while(!pq.isEmpty() && sum > half) {
            double val = pq.poll();
            double expression = val/2.0;
            sum -= expression;
            pq.add(expression);
            count++;
        }
        
        return count;
    }
}
