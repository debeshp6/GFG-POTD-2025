class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
     int i=0;
     int j=0;
     int k=0;
     
     while(k < s3.length()) {
        if(i < s1.length() && j < s2.length() &&
        s3.charAt(k) == s1.charAt(i) && s3.charAt(k) == s2.charAt(j)) {
            i++;
            j++;
         }
         
        if(i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
            i++;
        } else if(j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
            j++;
        }

        k++;
    }
    
    if(i==s1.length() && j==s2.length())return true;
    return false;
    }
}
