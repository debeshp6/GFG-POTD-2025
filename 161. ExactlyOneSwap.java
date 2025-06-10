class Solution {
    int countStrings(String s) {
        // code here
        int[] a=new int[26];
        for(char c: s.toCharArray())
        a[c-'a']++;
        int ans=0,extra=0;
        int l=s.length();
        for(int c : a){
            if(c>1)extra=1;
            ans+=(l-c)*c;
            l-=c;
        }
        return ans+extra;
    }
}

