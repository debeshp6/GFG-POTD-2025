

// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    private static Integer[] primes;
    private static boolean skipInit = false;
    
    public Solution() {
        if(skipInit) {
            return;
        }
        
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for(int i = 3; i <= 10_011; ++i) {
            final int j = i;
            if(primes.stream().allMatch((x) -> j % x != 0)) {
                primes.add(i);
            }
        }
        Solution.primes = new Integer[primes.size()];
        Solution.primes = primes.toArray(Solution.primes);
        Solution.skipInit = true;
    }
    
    Node primeList(Node head) {
        if(head == null) {
            return null;
        }
        
        int val = Arrays.binarySearch(primes, head.val);
        if(val < 0) {
            int lVal = ~val - 1;
            int rVal = ~val;
            if (rVal == 0) {
                head.val = primes[rVal];
            } else if(head.val - primes[lVal] <= primes[rVal] - head.val) {
                head.val = primes[lVal];
            } else {
                head.val = primes[rVal];
            }
        }
        
        head.next = primeList(head.next);
        return head;
    }
}
