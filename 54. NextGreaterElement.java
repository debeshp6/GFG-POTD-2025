

class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
       
       ArrayList<Integer> list = new ArrayList<>();
       Stack<Integer> st = new Stack<>();
       
       for(int i=0; i<arr.length; i++) {
           list.add(-1);
       }
       
       for(int i=arr.length-1; i>=0; i--) {
           while(!st.isEmpty() && st.peek() <= arr[i]) {
               st.pop();
           }
           
           if(!st.isEmpty()) {
               list.set(i, st.peek());
           }
           
           st.push(arr[i]);
       }
       
       return list;
    }
}
