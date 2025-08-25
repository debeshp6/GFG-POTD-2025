class Solution {
    public int maximizeMedian(int[] arr, int k) {
       int n = arr.length;
        int ind = 0;
        boolean fl = false;
        if(n%2 == 0) {
        	ind = (n/2)-1;
        	fl = true;
        } else ind = (n/2);
        
        
       Arrays.sort(arr);
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int i=ind; i<n; i++) {
           pq.add(arr[i]);
       }
       
       while(k --> 0) {
           int a = pq.remove();
           a++;
           pq.add(a);
       }
       
        if(fl == false) return pq.remove();
        else {
            int a = pq.remove();
            int b = pq.remove();
            return (a+b)/2;
        }
        
    }
}
