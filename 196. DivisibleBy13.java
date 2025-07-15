class Solution {
    public boolean divby13(String s) {
        // code here
       int mod = 0;
       
       for ( int i=0;i<s.length();i++){
           char ch = s.charAt(i);
           
           mod = (mod*10 + (ch -'0'))%13;
           
       }
       return mod == 0;
    }
}
