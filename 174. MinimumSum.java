

// User function Template for Java

class Solution {
    String minSum(int[] arr) {
        // code here
        StringBuilder str = new StringBuilder();
        Arrays.sort(arr);
        int carry = 0, n = arr.length, sum;
        for (int i=n-1; i>=0; i= i-2) {
            sum = arr[i] + (i-1 >= 0 ? arr[i-1] : 0) + carry;
            str.append(sum % 10);
            carry = sum / 10;
        }
        
        if(carry > 0) str.append(carry);
        
        while(str.charAt(str.length()-1) == '0') {
            str.delete(str.length()-1, str.length());
        }
        
        return str.reverse().toString();
    }
}



